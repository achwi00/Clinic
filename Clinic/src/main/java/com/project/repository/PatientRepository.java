package com.project.repository;

import com.project.clinic.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>
{
    boolean existsByEmailAndPassword(String email, String password);

    @Query("SELECT id FROM Patient WHERE email = :email AND password = :password")
    Long findIdByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    Optional<Patient> findById(Long patientId);

    boolean existsBySessionKey(String sessionKey);

    @Query("SELECT id FROM Patient WHERE sessionKey = :sessionKey")
    Long findIdBySessionKey(@Param("sessionKey") String sessionKey);

    @Query("SELECT id FROM Patient WHERE pesel = :pesel")
    Long findIdByPesel(@Param("pesel") String pesel);

    Patient findByEmail(String email);
}
