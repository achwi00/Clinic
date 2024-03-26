package com.project.repository;

import com.project.clinic.Doctor;
import com.project.clinic.Patient;
import com.project.clinic.Refferal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RefferalRepository extends JpaRepository<Refferal, Long>
{
    List<Refferal> findAllByPatientId(Long patientId);

    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO Refferal (patient, doctor, description, type) " +
            "VALUES (:patient, :doctor, :description, :type)")
    void insertRefferal(@Param("patient") int patient,
                        @Param("doctor") int doctor,
                        @Param("description") String description,
                        @Param("type") String type);

}
