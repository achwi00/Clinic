package com.project.repository;

import com.project.clinic.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Long>{
    @Override
    Optional<Clinic> findById(Long clinicId);
}
