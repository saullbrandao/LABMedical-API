package com.labmedicine.labmedicalapi.dtos.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserPasswordDto {
    @Size(min = 8)
    @NotBlank
    private String password;
}
