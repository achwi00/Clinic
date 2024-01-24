package com.project.service;

import com.project.clinic.Clinic;
import com.project.repository.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicService
{
    @Autowired
    private ClinicRepository clinicRepository;

    public List<Clinic> getAllClinics(){
        List<Clinic> allClinics = clinicRepository.findAll();
        return allClinics;
    }

    public Optional<Clinic> geClinicById(Long clinicId){

        return  clinicRepository.findById(clinicId);
    }

}