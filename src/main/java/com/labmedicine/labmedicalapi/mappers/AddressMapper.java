package com.labmedicine.labmedicalapi.mappers;

import com.labmedicine.labmedicalapi.dtos.AddressDto;
import com.labmedicine.labmedicalapi.models.Address;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {
    Address map(AddressDto source);

    AddressDto map(Address source);
}