package com.project.repository;

import com.project.clinic.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>
{
    boolean existsByEmailAndPassword(String email, String password);

    boolean existsBySessionKey(String sessionKey);

    @Query("SELECT id FROM Doctor WHERE sessionKey = :sessionKey")
    Long findIdBySessionKey(@Param("sessionKey") String sessionKey);

    @Query("SELECT id FROM Doctor WHERE email = :email AND password = :password")
    Long findIdByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Query("SELECT DISTINCT d.specialisation FROM Doctor d")
    List<String> findDistinctSpecializations();

}
