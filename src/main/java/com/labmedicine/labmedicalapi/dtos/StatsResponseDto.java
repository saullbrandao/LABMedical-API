package com.labmedicine.labmedicalapi.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatsResponseDto {
    private Long patients, appointments, exams;
}
