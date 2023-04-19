package com.labmedicine.labmedicalapi.dtos.user;

import com.labmedicine.labmedicalapi.dtos.person.PersonResponseDto;
import com.labmedicine.labmedicalapi.utils.MedicalSpecialization;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = false)
@Data
public class UserResponseDto extends PersonResponseDto {
    private String crm;
    private MedicalSpecialization specialization;
}
