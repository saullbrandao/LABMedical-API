package com.labmedicine.labmedicalapi.dtos.person;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.labmedicine.labmedicalapi.utils.MaritalStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
public abstract class UpdatePersonDto {
    private Long id;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String name, gender, phone, nationality;

    @JsonFormat(pattern="dd-MM-yyyy")
    @NotNull
    private LocalDate birthDate;

    @NotNull
    private MaritalStatus maritalStatus;
}
