package com.labmedicine.labmedicalapi.repositories;

import com.labmedicine.labmedicalapi.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByCpf(String cpf);
}
