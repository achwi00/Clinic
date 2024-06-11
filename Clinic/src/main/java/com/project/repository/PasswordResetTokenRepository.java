package com.project.repository;

import com.project.clinic.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    PasswordResetToken findByToken(String token);

    Optional<PasswordResetToken> findByEmailToReset(String email);
}
