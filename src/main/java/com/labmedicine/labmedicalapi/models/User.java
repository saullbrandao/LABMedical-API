package com.labmedicine.labmedicalapi.models;

import com.labmedicine.labmedicalapi.utils.MedicalSpecialization;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class User extends Person {
    @NotNull
    private String crm;

    @NotNull
    @Size(min = 8)
    private String password;

    @NotNull
    private MedicalSpecialization specialization;
}
