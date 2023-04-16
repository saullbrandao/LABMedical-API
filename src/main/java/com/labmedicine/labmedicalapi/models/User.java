package com.labmedicine.labmedicalapi.models;

import com.labmedicine.labmedicalapi.utils.MedicalSpecialization;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity(name = "users")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class User extends Person {
    @NotNull
    private String crm;

    @NotNull
    @Size(min = 8)
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private MedicalSpecialization specialization;
}
