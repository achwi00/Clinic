package com.project.repository;

import com.project.clinic.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.Select;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long>
{
    @Query("Select v FROM Visit v WHERE doctorId= :doctorId")
    List<Visit> findByDoctorId(@Param("doctorID")Long doctorId);
}
