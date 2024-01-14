package com.project.service;

import com.project.clinic.Visit;
import com.project.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Visit> findByDoctorId(Long doctorId)
    {
        List<Visit> visits = visitRepository.findByDoctorId(doctorId);
        return visits;
    }

}
