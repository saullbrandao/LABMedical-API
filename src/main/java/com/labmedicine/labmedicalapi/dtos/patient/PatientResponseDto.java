package com.labmedicine.labmedicalapi.dtos.patient;

import com.labmedicine.labmedicalapi.dtos.person.PersonResponseDto;
import com.labmedicine.labmedicalapi.models.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = false)
@Data
public class PatientResponseDto extends PersonResponseDto {
    private String allergies, specificCare, insurance, insuranceCardNumber;
    private LocalDate insuranceExpirationDate;

    @NotBlank
    private String emergencyContact;

    @NotNull
    private Address address;
}
