package com.labmedicine.labmedicalapi.mappers;

import com.labmedicine.labmedicalapi.dtos.appointment.AppointmentRequestDto;
import com.labmedicine.labmedicalapi.dtos.appointment.AppointmentResponseDto;
import com.labmedicine.labmedicalapi.models.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AppointmentMapper {
    @Mapping(target = "patient.id", source = "patientId")
    Appointment map(AppointmentRequestDto source);

    @Mapping(target = "patientId", source = "patient.id")
    AppointmentResponseDto map(Appointment source);
}
