package com.project.service;

import com.project.clinic.Visit;
import com.project.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitService
{
    @Autowired
    private VisitRepository visitRepository;

    public List<Visit> getAllVisits(){
        List<Visit> visitList = visitRepository.findAll();
        return visitList;
    }
    public List<Visit> findVisitByDoctorId(Long doctorId)
    {
        List<Visit> visits = visitRepository.findVisitByDoctorId(doctorId);
        return visits;
    }

}
