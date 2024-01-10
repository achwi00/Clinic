package com.project.service;

import com.project.clinic.Clinic;
import com.project.clinic.Doctor;
import com.project.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors(){
        List<Doctor> allDoctors = doctorRepository.findAll();
        return allDoctors;
    }

    public Optional<Doctor> getDoctorById(Long doctorId){
        return  doctorRepository.findById(doctorId);
    }

}
