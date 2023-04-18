package com.labmedicine.labmedicalapi.services;

import com.labmedicine.labmedicalapi.dtos.patient.CreatePatientDto;
import com.labmedicine.labmedicalapi.mappers.PatientMapper;
import com.labmedicine.labmedicalapi.models.Address;
import com.labmedicine.labmedicalapi.models.Patient;
import com.labmedicine.labmedicalapi.repositories.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

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

    public Patient create(CreatePatientDto createPatientDto) {
        Address address = addressService.findById(createPatientDto.getAddressId());
        Patient mappedPatient = patientMapper.map(createPatientDto);
        mappedPatient.setAddress(address);
        Patient createdPatient = patientRepository.save(mappedPatient);
        return patientRepository.findById(createdPatient.getId()).orElseThrow(EntityNotFoundException::new);
    }

    public Patient findByCpf(String cpf) {
        return patientRepository.findByCpf(cpf);
    }


}
