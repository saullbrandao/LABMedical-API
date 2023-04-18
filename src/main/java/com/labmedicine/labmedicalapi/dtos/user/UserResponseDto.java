package com.labmedicine.labmedicalapi.dtos.user;

import com.labmedicine.labmedicalapi.dtos.person.PersonResponseDto;
import com.labmedicine.labmedicalapi.utils.MedicalSpecialization;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = false)
@Data
public class UserResponseDto extends PersonResponseDto {
    @NotNull
    private String crm;

    @NotNull
    private MedicalSpecialization specialization;
}
