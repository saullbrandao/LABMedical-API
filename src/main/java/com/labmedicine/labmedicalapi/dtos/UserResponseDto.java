package com.labmedicine.labmedicalapi.dtos;

import com.labmedicine.labmedicalapi.utils.MedicalSpecialization;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = false)
@Data
public class UserResponseDto extends PersonDto {
    @NotNull
    private String crm;

    @NotNull
    private MedicalSpecialization specialization;
}
