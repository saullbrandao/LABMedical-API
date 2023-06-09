package com.labmedicine.labmedicalapi.services;

import com.labmedicine.labmedicalapi.dtos.patient.CreatePatientDto;
import com.labmedicine.labmedicalapi.dtos.patient.PatientResponseDto;
import com.labmedicine.labmedicalapi.dtos.patient.UpdatePatientDto;
import com.labmedicine.labmedicalapi.exceptions.PatientHasAppointmentsException;
import com.labmedicine.labmedicalapi.exceptions.PatientHasExamsException;
import com.labmedicine.labmedicalapi.mappers.PatientMapper;
import com.labmedicine.labmedicalapi.models.Address;
import com.labmedicine.labmedicalapi.models.Patient;
import com.labmedicine.labmedicalapi.repositories.AppointmentRepository;
import com.labmedicine.labmedicalapi.repositories.ExamRepository;
import com.labmedicine.labmedicalapi.repositories.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;
    private final AddressService addressService;
    private final ExamRepository examRepository;
    private final AppointmentRepository appointmentRepository;

    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper, AddressService addressService, ExamRepository examRepository, AppointmentRepository appointmentRepository) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
        this.addressService = addressService;
        this.examRepository = examRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public PatientResponseDto create(CreatePatientDto createPatientDto) {
        Address address = addressService.getAddressById(createPatientDto.getAddressId());
        Patient mappedPatient = patientMapper.map(createPatientDto);
        mappedPatient.setAddress(address);

        Patient createdPatient = patientRepository.save(mappedPatient);
        return patientMapper.map(createdPatient);
    }

    public PatientResponseDto update(UpdatePatientDto updatePatientDto, String id) {
        Patient patientFound = findById(id);
        Address address = addressService.getAddressById(updatePatientDto.getAddressId());
        Patient mappedPatient = patientMapper.map(updatePatientDto);
        mappedPatient.setId(id);
        mappedPatient.setCpf(patientFound.getCpf());
        mappedPatient.setRg(patientFound.getRg());
        mappedPatient.setAddress(address);

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

    public PatientResponseDto getPatientById(String id) {
        Patient patient = findById(id);
        return patientMapper.map(patient);
    }

    public Patient findById(String id) {
        return patientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Patient not found."));
    }

    public void deleteById(String id) {
        Patient patient = findById(id);
        if(examRepository.existsByPatientId(id)) {
            throw new PatientHasExamsException();
        }

        if(appointmentRepository.existsByPatientId(id)) {
            throw new PatientHasAppointmentsException();
        }

        patientRepository.deleteById(id);
    }
}
