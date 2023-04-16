package com.labmedicine.labmedicalapi.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddressDto {
    @NotBlank
    private String cep, city, street, district, state;

    @NotNull
    private Integer addressNumber;

    private String complement, referencePoint;
}
