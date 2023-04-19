package com.labmedicine.labmedicalapi.services;

import com.labmedicine.labmedicalapi.dtos.user.CreateUserDto;
import com.labmedicine.labmedicalapi.dtos.user.UpdateUserDto;
import com.labmedicine.labmedicalapi.dtos.user.UserPasswordDto;
import com.labmedicine.labmedicalapi.dtos.user.UserResponseDto;
import com.labmedicine.labmedicalapi.mappers.UserMapper;
import com.labmedicine.labmedicalapi.models.User;
import com.labmedicine.labmedicalapi.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public UserResponseDto create(CreateUserDto createUserDto) {
        User user = userMapper.map(createUserDto);
        return userMapper.map(userRepository.save(user));
    }

    public List<UserResponseDto> listAll() {
        return userMapper.map(userRepository.findAll());
    }

    public User findByCpf(String cpf) {
        return userRepository.findByCpf(cpf);
    }

    public UserResponseDto update(UpdateUserDto updateUserDto, Long id) {
        User userFound = findById(id);
        User mappedUser = userMapper.map(updateUserDto);
        mappedUser.setCpf(userFound.getCpf());
        mappedUser.setRg(userFound.getRg());
        mappedUser.setPassword(userFound.getPassword());

        User updatedUser = userRepository.save(mappedUser);
        return userMapper.map(updatedUser);
    }

    public UserResponseDto updatePassword(UserPasswordDto userPasswordDto, Long id) {
        User userFound = findById(id);
        userFound.setPassword(userPasswordDto.getPassword());
        User updatedUser = userRepository.save(userFound);

        return userMapper.map(updatedUser);
    }

    private User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User nor found"));
    }
}
