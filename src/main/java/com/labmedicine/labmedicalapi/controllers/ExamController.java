package com.labmedicine.labmedicalapi.controllers;

import com.labmedicine.labmedicalapi.dtos.exam.ExamRequestDto;
import com.labmedicine.labmedicalapi.dtos.exam.ExamResponseDto;
import com.labmedicine.labmedicalapi.services.ExamService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/exams")
public class ExamController {
    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping
    public ResponseEntity<ExamResponseDto> create(@RequestBody @Valid ExamRequestDto examRequestDto, UriComponentsBuilder uriComponentsBuilder) {
        ExamResponseDto exam = examService.create(examRequestDto);
        URI uri = uriComponentsBuilder.path("/exams/{id}").buildAndExpand(exam.getId()).toUri();
        return ResponseEntity.created(uri).body(exam);
    }

    @PutMapping("/{id}")
    public ExamResponseDto update(@RequestBody @Valid ExamRequestDto examRequestDto, @PathVariable Long id) {
        return examService.update(examRequestDto, id);
    }
}
