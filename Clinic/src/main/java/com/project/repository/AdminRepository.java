package com.project.repository;

import com.project.clinic.Admin;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>
{
    boolean existsByEmailAndPassword(String email, String password);
    boolean existsBySessionKey(String sessionKey);

    @Query("SELECT id FROM Admin WHERE email = :email AND password = :password")
    Long findIdByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    Optional<Admin> findById(Long adminId);
    public List<Admin> findAll();

    @Query("SELECT id FROM Admin WHERE sessionKey = :sessionKey")
    Long findIdBySessionKey(@Param("sessionKey") String sessionKey);

    @Transactional
    @Modifying
    @Query("UPDATE Admin SET sessionKey = null WHERE id = :adminId")
    void updateSessionKey(@Param("adminId") Long adminId);
}
