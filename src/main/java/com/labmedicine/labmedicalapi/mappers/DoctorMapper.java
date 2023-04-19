package com.labmedicine.labmedicalapi.mappers;

import com.labmedicine.labmedicalapi.dtos.doctor.CreateDoctorDto;
import com.labmedicine.labmedicalapi.dtos.doctor.DoctorResponseDto;
import com.labmedicine.labmedicalapi.dtos.doctor.UpdateDoctorDto;
import com.labmedicine.labmedicalapi.models.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DoctorMapper {
    Doctor map(CreateDoctorDto source);
    Doctor map(UpdateDoctorDto source);

    DoctorResponseDto map(Doctor source);

    List<DoctorResponseDto> map(List<Doctor> source);
}
