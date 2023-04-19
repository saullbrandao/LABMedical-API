package com.labmedicine.labmedicalapi.dtos.appointment;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentResponseDto {
    private Long id, patientId, doctorId;
    private String reason, description, prescription, precautions;
    private LocalDateTime time;
}
