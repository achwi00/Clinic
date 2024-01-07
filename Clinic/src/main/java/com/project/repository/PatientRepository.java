package com.project.repository;

import com.project.clinic.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>
{
    boolean existsByEmailAndPassword(String email, String password);
}
