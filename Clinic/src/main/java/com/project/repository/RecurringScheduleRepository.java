package com.project.repository;

import com.project.clinic.RecurringSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecurringScheduleRepository extends JpaRepository<RecurringSchedule, Long>
{
}
