package com.labmedicine.labmedicalapi.dtos.exam;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class ExamRequestDto {
    @NotBlank
    private String name, type, result, laboratory;

    @URL
    @NotBlank
    private String fileUrl;

    @NotNull
    private Long patientId;
}
