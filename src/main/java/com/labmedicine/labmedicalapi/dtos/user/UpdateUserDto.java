package com.labmedicine.labmedicalapi.dtos.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.labmedicine.labmedicalapi.utils.MaritalStatus;
import com.labmedicine.labmedicalapi.utils.MedicalSpecialization;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public  class UpdateUserDto {
    private Long id;

    @Email
    private String email;

    private String name, gender, phone, nationality;

    @JsonFormat(pattern="dd-MM-yyyy")
    @NotNull
    private LocalDate birthDate;

    @NotNull
    private MaritalStatus maritalStatus;

    @NotBlank
    private String crm;

    @NotNull
    private MedicalSpecialization specialization;
}
