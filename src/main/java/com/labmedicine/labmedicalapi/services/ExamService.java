package com.labmedicine.labmedicalapi.services;

import com.labmedicine.labmedicalapi.dtos.exam.ExamRequestDto;
import com.labmedicine.labmedicalapi.dtos.exam.ExamResponseDto;
import com.labmedicine.labmedicalapi.mappers.ExamMapper;
import com.labmedicine.labmedicalapi.models.Exam;
import com.labmedicine.labmedicalapi.models.Patient;
import com.labmedicine.labmedicalapi.repositories.ExamRepository;
import com.labmedicine.labmedicalapi.repositories.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ExamService {
    private final ExamRepository examRepository;
    private final PatientRepository patientRepository;
    private final ExamMapper examMapper;

    public ExamService(ExamRepository examRepository, PatientRepository patientRepository, ExamMapper examMapper) {
        this.examRepository = examRepository;
        this.patientRepository = patientRepository;
        this.examMapper = examMapper;
    }

    public ExamResponseDto create(ExamRequestDto examRequestDto) {
        Patient patient = findPatientById(examRequestDto.getPatientId());
        Exam mappedExam = examMapper.map(examRequestDto);
        mappedExam.setPatient(patient);
        Exam createdExam = examRepository.save(mappedExam);

        return examMapper.map(createdExam);
    }

    public ExamResponseDto update(ExamRequestDto examRequestDto, Long examId) {
        Exam exam = findExamById(examId);
        Patient patient = findPatientById(examRequestDto.getPatientId());
        Exam mappedExam = examMapper.map(examRequestDto);
        mappedExam.setTime(exam.getTime());
        mappedExam.setId(examId);
        mappedExam.setPatient(patient);

        Exam updatedExam = examRepository.save(mappedExam);
        return examMapper.map(updatedExam);
    }

    public ExamResponseDto getExamById(Long id) {
        Exam exam = findExamById(id);
        return examMapper.map(exam);
    }

    private Exam findExamById(Long id) {
        return examRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Exam not found."));
    }

    private Patient findPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Patient not found"));
    }
}
