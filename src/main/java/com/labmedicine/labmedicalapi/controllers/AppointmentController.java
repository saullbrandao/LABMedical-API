package com.labmedicine.labmedicalapi.controllers;

import com.labmedicine.labmedicalapi.dtos.appointment.AppointmentRequestDto;
import com.labmedicine.labmedicalapi.dtos.appointment.AppointmentResponseDto;
import com.labmedicine.labmedicalapi.services.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/{id}")
    public AppointmentResponseDto getById(@PathVariable String id) {
        return appointmentService.getAppointmentById(id);
    }

    @PostMapping
    public ResponseEntity<AppointmentResponseDto> create(@RequestBody @Valid AppointmentRequestDto appointmentRequestDto, UriComponentsBuilder uriComponentsBuilder) {
        AppointmentResponseDto appointment = appointmentService.create(appointmentRequestDto);
        URI uri = uriComponentsBuilder.path("/appointments/{id}").buildAndExpand(appointment.getId()).toUri();
        return ResponseEntity.created(uri).body(appointment);
    }

    @PutMapping("/{id}")
    public AppointmentResponseDto update(@RequestBody @Valid AppointmentRequestDto appointmentRequestDto, @PathVariable String id) {
        return appointmentService.update(appointmentRequestDto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        appointmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
