package com.project.repository;

import com.project.clinic.Visit;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long>
{


    @Query("SELECT v FROM Visit v " +
            "JOIN v.doctor d " +
            "WHERE d.specialisation = :specialisation " +
            "AND v.status = 'FREE' " +
            "AND v.date BETWEEN :startDate AND :endDate")
    List<Visit> findFreeVisitsBySpecialisationAndDate(
            String specialisation, LocalDate startDate, LocalDate endDate
    );

    @Transactional
    @Modifying
    @Query("UPDATE Visit v SET v.status = 'BOOKED', v.patient.id = :patientId WHERE v.visitId = :visitId")
    void updateVisitStatusAndPatientId(@Param("visitId") Long visitId,
                                       @Param("patientId") Long patientId);

    @Query("SELECT v FROM Visit v WHERE v.patient.id = :patientId AND v.status = 'BOOKED'")
    List<Visit> findBookedVisitsForPatient(@Param("patientId") Long patientId);

    @Query("SELECT v FROM Visit v WHERE v.patient.id = :patientId AND v.status = 'COMPLETED'")
    List<Visit> findCompletedVisitsForPatient(@Param("patientId") Long patientId);

    @Query("SELECT v FROM Visit v WHERE v.doctor.id = :doctorId AND v.date = :date AND (v.status = 'BOOKED'OR v.status = 'COMPLETED') ORDER BY v.time")
    List<Visit> findBookedAndCompletedForDoctorByDate(@Param("date") LocalDate date,
            @Param("doctorId") Long doctorId);

    List<Visit> findByPatientId(@Param("patientId") Long patientId);

//    @Query("UPDATE Visit v SET v.status = 'FREE', v.patient.id = NULL WHERE v.visitId = ?1")
//    void updateVisitStatusAndPatientIdToNull(Long visitId);
}
