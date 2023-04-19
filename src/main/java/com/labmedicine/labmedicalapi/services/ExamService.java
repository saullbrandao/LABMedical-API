package com.labmedicine.labmedicalapi.services;

import com.labmedicine.labmedicalapi.dtos.exam.ExamRequestDto;
import com.labmedicine.labmedicalapi.dtos.exam.ExamResponseDto;
import com.labmedicine.labmedicalapi.mappers.ExamMapper;
import com.labmedicine.labmedicalapi.models.Doctor;
import com.labmedicine.labmedicalapi.models.Exam;
import com.labmedicine.labmedicalapi.models.Patient;
import com.labmedicine.labmedicalapi.repositories.ExamRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ExamService {
    private final ExamRepository examRepository;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final ExamMapper examMapper;

    public ExamService(ExamRepository examRepository, PatientService patientService, DoctorService doctorService, ExamMapper examMapper) {
        this.examRepository = examRepository;
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.examMapper = examMapper;
    }

    public ExamResponseDto create(ExamRequestDto examRequestDto) {
        Patient patient = patientService.findById(examRequestDto.getPatientId());
        Doctor doctor = doctorService.findById(examRequestDto.getDoctorId());
        Exam mappedExam = examMapper.map(examRequestDto);
        mappedExam.setPatient(patient);
        mappedExam.setDoctor(doctor);

        Exam createdExam = examRepository.save(mappedExam);
        return examMapper.map(createdExam);
    }

    public ExamResponseDto update(ExamRequestDto examRequestDto, String examId) {
        Exam exam = findById(examId);
        Patient patient = patientService.findById(examRequestDto.getPatientId());
        Doctor doctor = doctorService.findById(examRequestDto.getDoctorId());
        Exam mappedExam = examMapper.map(examRequestDto);
        mappedExam.setTime(exam.getTime());
        mappedExam.setId(examId);
        mappedExam.setPatient(patient);
        mappedExam.setDoctor(doctor);

        Exam updatedExam = examRepository.save(mappedExam);
        return examMapper.map(updatedExam);
    }

    public ExamResponseDto getExamById(String id) {
        Exam exam = findById(id);
        return examMapper.map(exam);
    }

    public void deleteById(String id) {
        findById(id);
        examRepository.deleteById(id);
    }

    public Exam findById(String id) {
        return examRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Exam not found."));
    }
}
