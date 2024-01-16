package com.project.service;

import com.project.clinic.Doctor;
import com.project.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService
{
    @Autowired
    private DoctorRepository doctorRepository;

    public void updateSessionKey(Long doctorId, String newSessionKey) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);

        optionalDoctor.ifPresent(doctor -> {
            // Update the sessionKey
            doctor.setSessionKey(newSessionKey);

            // Save the updated patient back to the database
            doctorRepository.save(doctor);
        });
    }
    public List<String> getAllSpecialisations(){
        return doctorRepository.findDistinctSpecializations();
    }

    public Optional<Doctor> getPatientById(Long doctorId){
        return  doctorRepository.findById(doctorId);
    }
}
