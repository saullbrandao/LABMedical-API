package com.labmedicine.labmedicalapi.mappers;

import com.labmedicine.labmedicalapi.dtos.user.CreateUserDto;
import com.labmedicine.labmedicalapi.dtos.user.UpdateUserDto;
import com.labmedicine.labmedicalapi.dtos.user.UserResponseDto;
import com.labmedicine.labmedicalapi.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User map(CreateUserDto source);
    User map(UpdateUserDto source);

    UserResponseDto map(User source);

    List<UserResponseDto> map(List<User> source);
}
