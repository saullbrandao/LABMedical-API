package com.labmedicine.labmedicalapi.dtos.appointment;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentResponseDto {
    private String id, patientId, doctorId, reason, description, prescription, precautions;
    private LocalDateTime time;
}
