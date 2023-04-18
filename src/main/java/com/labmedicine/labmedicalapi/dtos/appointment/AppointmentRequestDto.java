package com.labmedicine.labmedicalapi.dtos.appointment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AppointmentRequestDto {
    @NotBlank
    private String reason, description, prescription, precautions;

    @NotNull
    private Long patientId;
}
