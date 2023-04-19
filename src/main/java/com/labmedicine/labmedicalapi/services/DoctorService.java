package com.labmedicine.labmedicalapi.services;

import com.labmedicine.labmedicalapi.dtos.doctor.CreateDoctorDto;
import com.labmedicine.labmedicalapi.dtos.doctor.DoctorResponseDto;
import com.labmedicine.labmedicalapi.dtos.doctor.UpdateDoctorDto;
import com.labmedicine.labmedicalapi.dtos.doctor.UpdateDoctorPasswordDto;
import com.labmedicine.labmedicalapi.mappers.DoctorMapper;
import com.labmedicine.labmedicalapi.models.Doctor;
import com.labmedicine.labmedicalapi.repositories.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public DoctorService(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    public DoctorResponseDto create(CreateDoctorDto createDoctorDto) {
        Doctor doctor = doctorMapper.map(createDoctorDto);
        return doctorMapper.map(doctorRepository.save(doctor));
    }

    public List<DoctorResponseDto> listAll() {
        return doctorMapper.map(doctorRepository.findAll());
    }

    public Doctor getByCpf(String cpf) {
        return doctorRepository.findByCpf(cpf);
    }

    public DoctorResponseDto update(UpdateDoctorDto updateDoctorDto, String id) {
        Doctor doctorFound = findById(id);
        Doctor mappedDoctor = doctorMapper.map(updateDoctorDto);
        mappedDoctor.setId(id);
        mappedDoctor.setCpf(doctorFound.getCpf());
        mappedDoctor.setRg(doctorFound.getRg());
        mappedDoctor.setPassword(doctorFound.getPassword());

        Doctor updatedDoctor = doctorRepository.save(mappedDoctor);
        return doctorMapper.map(updatedDoctor);
    }

    public DoctorResponseDto updatePassword(UpdateDoctorPasswordDto updateDoctorPasswordDto, String id) {
        Doctor doctorFound = findById(id);
        doctorFound.setPassword(updateDoctorPasswordDto.getPassword());
        Doctor updatedDoctor = doctorRepository.save(doctorFound);

        return doctorMapper.map(updatedDoctor);
    }

    public Doctor findById(String id) {
        return doctorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Doctor not found"));
    }
}
