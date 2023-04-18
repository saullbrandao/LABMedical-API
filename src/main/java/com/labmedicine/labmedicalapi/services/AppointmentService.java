package com.labmedicine.labmedicalapi.services;

import com.labmedicine.labmedicalapi.dtos.appointment.AppointmentRequestDto;
import com.labmedicine.labmedicalapi.dtos.appointment.AppointmentResponseDto;
import com.labmedicine.labmedicalapi.mappers.AppointmentMapper;
import com.labmedicine.labmedicalapi.models.Appointment;
import com.labmedicine.labmedicalapi.models.Patient;
import com.labmedicine.labmedicalapi.repositories.AppointmentRepository;
import com.labmedicine.labmedicalapi.repositories.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final AppointmentMapper appointmentMapper;

    public AppointmentService(AppointmentRepository appointmentRepository, PatientRepository patientRepository, AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.appointmentMapper = appointmentMapper;
    }

    public AppointmentResponseDto create(AppointmentRequestDto appointmentRequestDto) {
        Patient patient = patientRepository.findById(appointmentRequestDto.getPatientId()).orElseThrow(EntityNotFoundException::new);
        Appointment mappedAppointment = appointmentMapper.map(appointmentRequestDto);
        mappedAppointment.setPatient(patient);
        Appointment createdAppointment = appointmentRepository.save(mappedAppointment);

        return appointmentMapper.map(createdAppointment);
    }
}
