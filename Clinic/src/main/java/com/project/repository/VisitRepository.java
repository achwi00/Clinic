package com.project.repository;

import com.project.clinic.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.Select;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long>
{
    //query zakomentowane bo wywala błąd, ale no trezba je poprawić bo bez tego razcej nie pobierze tych danych
    //@Query("SELECT v FROM Visit v WHERE v.doctorId = :doctorId")
    List<Visit> findByDoctorId(Long doctorId);
}
