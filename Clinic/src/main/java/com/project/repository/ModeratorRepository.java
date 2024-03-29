package com.project.repository;

import com.project.clinic.Moderator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeratorRepository extends JpaRepository<Moderator, Long>
{
    boolean existsByEmailAndPassword(String email, String password);
    boolean existsBySessionKey(String sessionKey);
}
