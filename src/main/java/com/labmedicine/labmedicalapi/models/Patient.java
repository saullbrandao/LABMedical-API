package com.labmedicine.labmedicalapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity(name = "patients")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Patient extends Person {
    private String allergies, specificCare, insurance, insuranceCardNumber;
    private LocalDate insuranceExpirationDate;

    @NotNull
    private String emergencyContact;

    @ManyToOne
    @NotNull
    private Address address;
}
