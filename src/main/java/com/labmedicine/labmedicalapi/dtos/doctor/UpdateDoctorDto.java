package com.labmedicine.labmedicalapi.dtos.doctor;

import com.labmedicine.labmedicalapi.dtos.person.UpdatePersonDto;
import com.labmedicine.labmedicalapi.utils.MedicalSpecialization;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public  class UpdateDoctorDto extends UpdatePersonDto {
    @NotBlank
    private String crm;

    @NotNull
    private MedicalSpecialization specialization;
}
