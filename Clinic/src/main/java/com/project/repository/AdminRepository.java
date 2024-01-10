package com.project.repository;

import com.project.clinic.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>
{
    boolean existsByEmailAndPassword(String email, String password);
    @Query("SELECT id FROM Admin WHERE email = :email AND password = :password")
    Long findIdByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
