package com.labmedicine.labmedicalapi.services;

import com.labmedicine.labmedicalapi.dtos.patient.CreatePatientDto;
import com.labmedicine.labmedicalapi.dtos.patient.PatientResponseDto;
import com.labmedicine.labmedicalapi.dtos.patient.UpdatePatientDto;
import com.labmedicine.labmedicalapi.dtos.user.UpdateUserDto;
import com.labmedicine.labmedicalapi.dtos.user.UserResponseDto;
import com.labmedicine.labmedicalapi.mappers.PatientMapper;
import com.labmedicine.labmedicalapi.models.Address;
import com.labmedicine.labmedicalapi.models.Patient;
import com.labmedicine.labmedicalapi.models.User;
import com.labmedicine.labmedicalapi.repositories.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;
    private final AddressService addressService;

    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper, AddressService addressService) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
        this.addressService = addressService;
    }

    public PatientResponseDto create(CreatePatientDto createPatientDto) {
        Address address = addressService.findById(createPatientDto.getAddressId());
        Patient mappedPatient = patientMapper.map(createPatientDto);
        mappedPatient.setAddress(address);
        Patient createdPatient = patientRepository.save(mappedPatient);
        return patientMapper.map(createdPatient);
    }

    public PatientResponseDto updatePatient(UpdatePatientDto updatePatientDto) {
        Patient patientFound = patientRepository.findById(updatePatientDto.getId()).orElseThrow(EntityNotFoundException::new);

        Patient mappedPatient = patientMapper.map(updatePatientDto);
        mappedPatient.setCpf(patientFound.getCpf());
        mappedPatient.setRg(patientFound.getRg());

        Patient updatedPatient = patientRepository.save(mappedPatient);

        return patientMapper.map(updatedPatient);
    }

    public Patient findByCpf(String cpf) {
        return patientRepository.findByCpf(cpf);
    }

    public List<PatientResponseDto> listAll(String name) {
        if(name != null) {
            return patientMapper.map(patientRepository.findAllByNameContaining(name));
        }
        return patientMapper.map(patientRepository.findAll());
    }
}
