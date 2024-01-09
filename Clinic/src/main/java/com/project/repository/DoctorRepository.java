package com.project.repository;

import com.project.clinic.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>
{
    boolean existsByEmailAndPassword(String email, String password);
}
