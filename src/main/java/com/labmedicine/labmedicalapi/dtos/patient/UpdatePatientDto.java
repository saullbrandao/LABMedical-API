package com.labmedicine.labmedicalapi.dtos.patient;

import com.labmedicine.labmedicalapi.dtos.person.UpdatePersonDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = false)
@Data
public class UpdatePatientDto extends UpdatePersonDto {
    private String allergies, specificCare, insurance, insuranceCardNumber;
    private LocalDate insuranceExpirationDate;

    @NotBlank
    private String emergencyContact;

    @NotNull
    private Long addressId;
}
