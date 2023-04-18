package com.labmedicine.labmedicalapi.mappers;

import com.labmedicine.labmedicalapi.dtos.patient.CreatePatientDto;
import com.labmedicine.labmedicalapi.models.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PatientMapper {
    @Mapping(target = "address.id", source = "addressId")
    Patient map(CreatePatientDto source);

    CreatePatientDto map(Patient source);
}
