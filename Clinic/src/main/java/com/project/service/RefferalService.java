package com.project.service;

import com.project.clinic.Refferal;
import com.project.clinic.Visit;
import com.project.repository.RefferalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefferalService
{
    @Autowired
    public RefferalRepository refferalRepository;

    public List<Refferal> getAllRefferalsByPatientId(Long patientId){
        return refferalRepository.findAllByPatientId(patientId);
    }
}
