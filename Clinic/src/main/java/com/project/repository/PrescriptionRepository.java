package com.project.repository;

import com.project.clinic.Prescription;
import com.project.clinic.Refferal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long>
{
    List<Prescription> findAllByPatientId(Long patientId);
}
