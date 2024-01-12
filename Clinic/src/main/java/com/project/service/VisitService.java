package com.project.service;

import com.project.clinic.Visit;
import com.project.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public List<Visit> getAllVisitsIn(Date start, Date stop, String specialisation){

        //List<Visit> visits =
        return visitRepository.findAll();
    }


}
