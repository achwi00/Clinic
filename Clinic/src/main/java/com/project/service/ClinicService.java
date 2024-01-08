package com.project.service;

import com.project.clinic.Clinic;
import com.project.repository.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class ClinicService
    {
        @Autowired
        private ClinicRepository clinicRepository;


        public List<Clinic> getAllClinics(){
            List<Clinic> clinics = clinicRepository.findAll();
            return clinics;
        }

        public Optional<Clinic> getPatientById(Long clinicId){
            return  clinicRepository.findById(clinicId);
        }

    }
}
