package com.labmedicine.labmedicalapi.dtos.patient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.labmedicine.labmedicalapi.dtos.person.PersonResponseDto;
import com.labmedicine.labmedicalapi.models.Address;
import com.labmedicine.labmedicalapi.models.Exam;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
public class PatientResponseDto extends PersonResponseDto {
    private String allergies, specificCare, insurance, insuranceCardNumber, emergencyContact;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate insuranceExpirationDate;
    private Address address;

    private List<Exam> exams = new ArrayList<>();
}
