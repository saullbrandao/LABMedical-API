package com.labmedicine.labmedicalapi.dtos.appointment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentRequestDto {
    @NotBlank
    private String reason, description, prescription, precautions;

    @NotNull
    private Long patientId, doctorId;

    @Null
    private LocalDateTime time;
}
