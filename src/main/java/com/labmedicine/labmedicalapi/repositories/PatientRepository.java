package com.labmedicine.labmedicalapi.repositories;

import com.labmedicine.labmedicalapi.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByCpf(String cpf);
}
