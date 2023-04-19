package com.labmedicine.labmedicalapi.dtos.doctor;

import com.labmedicine.labmedicalapi.dtos.person.CreatePersonDto;
import com.labmedicine.labmedicalapi.utils.MedicalSpecialization;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = false)
@Data
public class CreateDoctorDto extends CreatePersonDto {
    @NotBlank
    private String crm;

    @NotNull
    private MedicalSpecialization specialization;

    @NotBlank
    @Size(min = 8, message = "Must be at least 8 characters")
    private String password;
}
