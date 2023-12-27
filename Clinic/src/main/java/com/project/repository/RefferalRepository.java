package com.project.repository;

import com.project.clinic.Refferal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefferalRepository extends JpaRepository<Refferal, Long>
{
}
