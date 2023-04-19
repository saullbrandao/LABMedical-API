package com.labmedicine.labmedicalapi.services;

import com.labmedicine.labmedicalapi.dtos.appointment.AppointmentRequestDto;
import com.labmedicine.labmedicalapi.dtos.appointment.AppointmentResponseDto;
import com.labmedicine.labmedicalapi.mappers.AppointmentMapper;
import com.labmedicine.labmedicalapi.models.Appointment;
import com.labmedicine.labmedicalapi.models.Doctor;
import com.labmedicine.labmedicalapi.models.Patient;
import com.labmedicine.labmedicalapi.repositories.AppointmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final AppointmentMapper appointmentMapper;

    public AppointmentService(AppointmentRepository appointmentRepository, PatientService patientService, DoctorService doctorService, AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.appointmentMapper = appointmentMapper;
    }

    public AppointmentResponseDto create(AppointmentRequestDto appointmentRequestDto) {
        Patient patient = patientService.findById(appointmentRequestDto.getPatientId());
        Doctor doctor = doctorService.findById(appointmentRequestDto.getDoctorId());
        Appointment mappedAppointment = appointmentMapper.map(appointmentRequestDto);
        mappedAppointment.setPatient(patient);
        mappedAppointment.setDoctor(doctor);

        Appointment createdAppointment = appointmentRepository.save(mappedAppointment);
        return appointmentMapper.map(createdAppointment);
    }

    public AppointmentResponseDto update(AppointmentRequestDto appointmentRequestDto, Long appointmentId) {
        Appointment appointmentFound = findById(appointmentId);
        Patient patient = patientService.findById(appointmentRequestDto.getPatientId());
        Doctor doctor = doctorService.findById(appointmentRequestDto.getDoctorId());
        Appointment mappedAppointment = appointmentMapper.map(appointmentRequestDto);
        mappedAppointment.setTime(appointmentFound.getTime());
        mappedAppointment.setId(appointmentId);
        mappedAppointment.setPatient(patient);
        mappedAppointment.setDoctor(doctor);

        Appointment updatedAppointment = appointmentRepository.save(mappedAppointment);
        return appointmentMapper.map(updatedAppointment);
    }

    public AppointmentResponseDto getAppointmentById(Long id) {
        Appointment appointment = findById(id);
        return appointmentMapper.map(appointment);
    }

    public void deleteById(Long id) {
        findById(id);
        appointmentRepository.deleteById(id);
    }

    public Appointment findById(Long id) {
        return appointmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Appointment not found."));
    }
}
