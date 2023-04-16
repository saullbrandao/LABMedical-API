package com.labmedicine.labmedicalapi.controllers;

import com.labmedicine.labmedicalapi.dtos.UserRequestDto;
import com.labmedicine.labmedicalapi.dtos.UserResponseDto;
import com.labmedicine.labmedicalapi.dtos.ValidationErrorDto;
import com.labmedicine.labmedicalapi.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid UserRequestDto userRequestDto, UriComponentsBuilder uriComponentsBuilder) {
        if(userService.findByCpf(userRequestDto.getCpf()) != null) {
            ValidationErrorDto error = new ValidationErrorDto(new FieldError("cpfError", "cpf", "This CPF is already registered."));
            return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
        }

        UserResponseDto createdUser = userService.create(userRequestDto);
        URI uri = uriComponentsBuilder.path("/users/{id}").buildAndExpand(createdUser.getId()).toUri();
        return  ResponseEntity.created(uri).body(createdUser);
    }

    @GetMapping
    public List<UserResponseDto> listAll() {
        return userService.listAll();
    }
}
