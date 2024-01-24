package com.project.repository;

import com.project.clinic.ClinicDoctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicDoctorRepository extends JpaRepository<ClinicDoctor, Long> {
}
