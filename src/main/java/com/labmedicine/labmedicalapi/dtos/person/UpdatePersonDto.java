package com.labmedicine.labmedicalapi.dtos.person;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.labmedicine.labmedicalapi.utils.Gender;
import com.labmedicine.labmedicalapi.utils.MaritalStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

import java.time.LocalDate;

@Data
public abstract class UpdatePersonDto {
    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String name, phone, nationality;

    @JsonFormat(pattern="dd/MM/yyyy")
    @NotNull
    private LocalDate birthDate;

    @NotNull
    private MaritalStatus maritalStatus;

    @NotNull
    private Gender gender;

    @Null
    private String cpf, rg;
}
