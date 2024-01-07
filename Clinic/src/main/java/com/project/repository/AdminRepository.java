package com.project.repository;

import com.project.clinic.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>
{
    boolean existsByEmailAndPassword(String email, String password);
}
