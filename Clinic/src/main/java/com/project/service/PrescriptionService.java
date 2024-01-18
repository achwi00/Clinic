package com.project.service;

import com.project.clinic.Prescription;
import com.project.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrescriptionService
{
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public List<Prescription> getAllPrescriptionsByPatientId(Long patientId){
        return prescriptionRepository.findAllByPatientId(patientId);
    }


}
