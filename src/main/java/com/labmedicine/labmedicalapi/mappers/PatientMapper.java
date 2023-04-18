package com.labmedicine.labmedicalapi.mappers;

import com.labmedicine.labmedicalapi.dtos.patient.CreatePatientDto;
import com.labmedicine.labmedicalapi.dtos.patient.PatientResponseDto;
import com.labmedicine.labmedicalapi.dtos.patient.UpdatePatientDto;
import com.labmedicine.labmedicalapi.models.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PatientMapper {
    @Mapping(target = "address.id", source = "addressId")
    Patient map(CreatePatientDto source);

    @Mapping(target = "address.id", source = "addressId")
    Patient map(UpdatePatientDto source);

    PatientResponseDto map(Patient source);

    List<PatientResponseDto> map(List<Patient> source);
}
