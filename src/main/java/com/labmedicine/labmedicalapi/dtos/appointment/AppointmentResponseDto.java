package com.labmedicine.labmedicalapi.dtos.appointment;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentResponseDto {
    private Long id;
    private String reason, description, prescription, precautions;
    private LocalDateTime time;
    private Long patientId;
}
