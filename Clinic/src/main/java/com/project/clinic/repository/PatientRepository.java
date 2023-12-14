package com.project.clinic.repository;

import com.project.clinic.Patient;
import com.project.clinic.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {
}
