package com.project.repository;

import com.project.clinic.Refferal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RefferalRepository extends JpaRepository<Refferal, Long>
{
    List<Refferal> findAllByPatientId(Long patientId);
}
