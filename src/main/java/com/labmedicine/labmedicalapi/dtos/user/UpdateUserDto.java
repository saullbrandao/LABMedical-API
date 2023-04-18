package com.labmedicine.labmedicalapi.dtos.user;

import com.labmedicine.labmedicalapi.dtos.person.UpdatePersonDto;
import com.labmedicine.labmedicalapi.utils.MaritalStatus;
import com.labmedicine.labmedicalapi.utils.MedicalSpecialization;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = false)
@Data
public  class UpdateUserDto extends UpdatePersonDto {
    @NotBlank
    private String crm;

    @NotNull
    private MedicalSpecialization specialization;
}
