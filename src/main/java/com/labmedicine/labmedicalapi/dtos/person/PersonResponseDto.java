package com.labmedicine.labmedicalapi.dtos.person;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.labmedicine.labmedicalapi.utils.Gender;
import com.labmedicine.labmedicalapi.utils.MaritalStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public abstract class PersonResponseDto {
    private String id, name, cpf, email, rg, phone, nationality;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate birthDate;

    private MaritalStatus maritalStatus;

    private Gender gender;
}
