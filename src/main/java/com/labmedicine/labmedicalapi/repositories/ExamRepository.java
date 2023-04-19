package com.labmedicine.labmedicalapi.repositories;

import com.labmedicine.labmedicalapi.models.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository  extends JpaRepository<Exam, Long> {
}
