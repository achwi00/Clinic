package com.project.repository;

import com.project.clinic.GeneralDailySchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralDailyScheduleRepository extends JpaRepository<GeneralDailySchedule, Long> {
}
