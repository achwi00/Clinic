package com.project.service;

import com.project.clinic.Clinic;
import com.project.clinic.ClinicDoctor;
import com.project.clinic.Doctor;
import com.project.repository.ClinicDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClinicDoctorService {
    @Autowired
    private ClinicDoctorRepository clinicDoctorRepository;

    public void dodajClinicDoctor( Doctor doctor,Clinic clinic){
        ClinicDoctor clinicDoctor = new ClinicDoctor();
        clinicDoctor.setClinic(clinic);
        clinicDoctor.setDoctor(doctor);
        clinicDoctorRepository.save(clinicDoctor);
    }
}