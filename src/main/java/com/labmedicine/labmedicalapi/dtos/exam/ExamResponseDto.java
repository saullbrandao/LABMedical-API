package com.labmedicine.labmedicalapi.dtos.exam;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExamResponseDto {
    private Long id, patientId, doctorId;
    private String name, type, fileUrl, result, laboratory;
    private LocalDateTime time;
}
