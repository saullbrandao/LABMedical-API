package com.labmedicine.labmedicalapi.controllers;

import com.labmedicine.labmedicalapi.dtos.ValidationErrorDto;
import com.labmedicine.labmedicalapi.dtos.patient.CreatePatientDto;
import com.labmedicine.labmedicalapi.dtos.patient.PatientResponseDto;
import com.labmedicine.labmedicalapi.dtos.patient.UpdatePatientDto;
import com.labmedicine.labmedicalapi.dtos.user.UpdateUserDto;
import com.labmedicine.labmedicalapi.dtos.user.UserResponseDto;
import com.labmedicine.labmedicalapi.models.Patient;
import com.labmedicine.labmedicalapi.services.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<PatientResponseDto> listAll(@RequestParam(required = false) String name) {
        return patientService.listAll(name);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreatePatientDto createPatientDto, UriComponentsBuilder uriComponentsBuilder) {
        if(patientService.findByCpf(createPatientDto.getCpf()) != null) {
            ValidationErrorDto error = new ValidationErrorDto(new FieldError("cpfError", "cpf", "This CPF is already registered."));
            return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
        }

        PatientResponseDto patient = patientService.create(createPatientDto);
        URI uri = uriComponentsBuilder.path("/patients/{id}").buildAndExpand(patient.getId()).toUri();
        return  ResponseEntity.created(uri).body(patient);
    }

    @PutMapping
    @RequestMapping("/{id}")
    public PatientResponseDto updatePatient(@RequestBody @Valid UpdatePatientDto updatePatientDto, @PathVariable Long id) {
        updatePatientDto.setId(id);
        return patientService.updatePatient(updatePatientDto);
    }


}
