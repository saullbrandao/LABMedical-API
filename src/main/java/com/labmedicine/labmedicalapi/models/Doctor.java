package com.labmedicine.labmedicalapi.models;

import com.labmedicine.labmedicalapi.utils.MedicalSpecialization;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "doctors")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends Person {
    @NotNull
    private String crm;

    @NotNull
    @Size(min = 8)
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private MedicalSpecialization specialization;
}
