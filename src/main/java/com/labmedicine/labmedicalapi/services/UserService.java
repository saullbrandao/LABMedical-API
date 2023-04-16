package com.labmedicine.labmedicalapi.services;

import com.labmedicine.labmedicalapi.dtos.UserRequestDto;
import com.labmedicine.labmedicalapi.dtos.UserResponseDto;
import com.labmedicine.labmedicalapi.mappers.UserMapper;
import com.labmedicine.labmedicalapi.models.User;
import com.labmedicine.labmedicalapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponseDto create(UserRequestDto userRequestDto) {
        User user = userMapper.map(userRequestDto);
        return userMapper.map(userRepository.save(user));
    }

    public List<UserResponseDto> listAll() {
        return userMapper.map(userRepository.findAll());
    }

    public User findByCpf(String cpf) {
        return userRepository.findByCpf(cpf);
    }
}
