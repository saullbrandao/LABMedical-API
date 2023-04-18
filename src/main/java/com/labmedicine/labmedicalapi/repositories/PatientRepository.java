package com.labmedicine.labmedicalapi.repositories;

import com.labmedicine.labmedicalapi.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByCpf(String cpf);
    List<Patient> findAllByNameContaining(String name);
}
