package com.project.clinic.repository;

import com.project.clinic.entity.PatientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
}
