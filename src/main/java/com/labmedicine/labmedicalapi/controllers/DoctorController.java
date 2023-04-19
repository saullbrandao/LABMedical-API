package com.labmedicine.labmedicalapi.controllers;

import com.labmedicine.labmedicalapi.dtos.doctor.CreateDoctorDto;
import com.labmedicine.labmedicalapi.dtos.doctor.DoctorResponseDto;
import com.labmedicine.labmedicalapi.dtos.doctor.UpdateDoctorDto;
import com.labmedicine.labmedicalapi.dtos.doctor.UpdateDoctorPasswordDto;
import com.labmedicine.labmedicalapi.exceptions.dto.ValidationErrorExceptionDto;
import com.labmedicine.labmedicalapi.services.DoctorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateDoctorDto createDoctorDto, UriComponentsBuilder uriComponentsBuilder) {
        if(doctorService.getByCpf(createDoctorDto.getCpf()) != null) {
            ValidationErrorExceptionDto error = new ValidationErrorExceptionDto(new FieldError("cpfError", "cpf", "This CPF is already registered."));
            return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
        }

        DoctorResponseDto createdUser = doctorService.create(createDoctorDto);
        URI uri = uriComponentsBuilder.path("/users/{id}").buildAndExpand(createdUser.getId()).toUri();
        return  ResponseEntity.created(uri).body(createdUser);
    }

    @PutMapping("/{id}")
    public DoctorResponseDto update(@RequestBody @Valid UpdateDoctorDto updateDoctorDto, @PathVariable Long id) {
        return doctorService.update(updateDoctorDto, id);
    }

    @PatchMapping("/{id}/password")
    public DoctorResponseDto updatePassword(@RequestBody @Valid UpdateDoctorPasswordDto updateDoctorPasswordDto, @PathVariable Long id) {
        return doctorService.updatePassword(updateDoctorPasswordDto, id);
    }

    @GetMapping
    public List<DoctorResponseDto> listAll() {
        return doctorService.listAll();
    }
}
