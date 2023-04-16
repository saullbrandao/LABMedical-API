package com.labmedicine.labmedicalapi.models;

import com.labmedicine.labmedicalapi.utils.MaritalStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@MappedSuperclass
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String cpf;

    private String name, gender, rg, phone, email, nationality;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private MaritalStatus maritalStatus;
}
