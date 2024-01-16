package com.project.controllers;

import com.project.clinic.Doctor;
import com.project.clinic.Patient;
import com.project.repository.DoctorRepository;
import com.project.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorApiController
{
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/all")
    public Optional<Doctor> getThisDoctor(@RequestParam String sessionKey)
    {
        //System.out.println("patientId from getThisPatient is: " + );
        Long doctorId = doctorRepository.findIdBySessionKey(sessionKey);

        Optional<Doctor> doctor = doctorService.getPatientById(doctorId);
        if(doctor==null)
        {
            System.out.println("Patient not found with the id: " + doctorId);
            return null;
        }
        System.out.println("our patient: " + doctor.toString());
        return doctor;
    }
}
