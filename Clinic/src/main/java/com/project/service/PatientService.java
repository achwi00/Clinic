package com.project.service;

import com.project.clinic.Patient;
import com.project.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService
{
    @Autowired
    private PatientRepository patientRepository;


    public List<Patient> getAllPatients(){
        List<Patient> patients = patientRepository.findAll();
        return patients;
    }

    public Optional<Patient> getPatientById(Long patientId){
        return  patientRepository.findById(patientId);
    }

}
