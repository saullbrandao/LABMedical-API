package com.labmedicine.labmedicalapi.dtos.exam;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExamResponseDto {
    private String id, patientId, doctorId, name, type, fileUrl, result, laboratory;
    private LocalDateTime time;
}
