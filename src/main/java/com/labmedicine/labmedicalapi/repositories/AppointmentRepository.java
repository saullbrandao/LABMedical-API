package com.labmedicine.labmedicalapi.repositories;

import com.labmedicine.labmedicalapi.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
