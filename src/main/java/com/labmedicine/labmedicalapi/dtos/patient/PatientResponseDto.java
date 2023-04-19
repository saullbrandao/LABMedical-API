package com.labmedicine.labmedicalapi.dtos.patient;

import com.labmedicine.labmedicalapi.dtos.person.PersonResponseDto;
import com.labmedicine.labmedicalapi.models.Address;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = false)
@Data
public class PatientResponseDto extends PersonResponseDto {
    private String allergies, specificCare, insurance, insuranceCardNumber, emergencyContact;
    private LocalDate insuranceExpirationDate;
    private Address address;
}
