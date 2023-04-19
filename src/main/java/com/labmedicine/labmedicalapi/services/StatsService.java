package com.labmedicine.labmedicalapi.services;

import com.labmedicine.labmedicalapi.dtos.StatsResponseDto;
import com.labmedicine.labmedicalapi.repositories.AppointmentRepository;
import com.labmedicine.labmedicalapi.repositories.ExamRepository;
import com.labmedicine.labmedicalapi.repositories.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class StatsService {
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;
    private final ExamRepository examRepository;

    public StatsService(PatientRepository patientRepository, AppointmentRepository appointmentRepository, ExamRepository examRepository) {
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
        this.examRepository = examRepository;
    }

    public StatsResponseDto getStats() {
        return StatsResponseDto.builder()
                .appointments(appointmentRepository.count())
                .exams(examRepository.count())
                .patients(patientRepository.count())
                .build();
    }
}
