package com.labmedicine.labmedicalapi.mappers;

import com.labmedicine.labmedicalapi.dtos.UserRequestDto;
import com.labmedicine.labmedicalapi.dtos.UserResponseDto;
import com.labmedicine.labmedicalapi.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User map(UserRequestDto source);

    UserResponseDto map(User source);

    List<UserResponseDto> map(List<User> source);
}
