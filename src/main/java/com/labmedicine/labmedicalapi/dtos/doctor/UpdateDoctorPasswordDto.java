package com.labmedicine.labmedicalapi.dtos.doctor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateDoctorPasswordDto {
    @Size(min = 8)
    @NotBlank
    private String password;
}
