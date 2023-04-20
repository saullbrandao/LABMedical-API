package com.labmedicine.labmedicalapi.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Exam> exams = new ArrayList<>();

}
