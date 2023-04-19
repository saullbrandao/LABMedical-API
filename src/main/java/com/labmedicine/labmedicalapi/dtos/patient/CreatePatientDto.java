package com.labmedicine.labmedicalapi.dtos.patient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.labmedicine.labmedicalapi.dtos.person.CreatePersonDto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = false)
@Data
public class CreatePatientDto extends CreatePersonDto {
    private String allergies, specificCare, insurance, insuranceCardNumber;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate insuranceExpirationDate;

    @NotBlank
    private String emergencyContact;

    @NotBlank
    private String addressId;
}
