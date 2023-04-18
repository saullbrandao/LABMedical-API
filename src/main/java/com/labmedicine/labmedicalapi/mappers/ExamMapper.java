package com.labmedicine.labmedicalapi.mappers;

import com.labmedicine.labmedicalapi.dtos.exam.ExamRequestDto;
import com.labmedicine.labmedicalapi.dtos.exam.ExamResponseDto;
import com.labmedicine.labmedicalapi.models.Exam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExamMapper {
    @Mapping(target = "patient.id", source = "patientId")
    Exam map(ExamRequestDto source);

    @Mapping(target = "patientId", source = "patient.id")
    ExamResponseDto map(Exam source);
}
