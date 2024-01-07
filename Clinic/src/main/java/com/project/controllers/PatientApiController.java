package com.project.controllers;

import com.project.clinic.Patient;
import com.project.repository.PatientRepository;
import com.project.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/patient")
public class PatientApiController
{
    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

//    @GetMapping("/all")
//    public List<Patient> getAllPatients()
//    {
//        List<Patient> patients = patientService.getAllPatients();
//        return patients;
//    }

    @GetMapping("/all")
    public Optional<Patient> getThisPatient(@RequestParam Long patientId)
    {
        System.out.println("patientId from getThisPatient is: " + patientId);

        Optional<Patient> patient = patientService.getPatientById(patientId);
        if(patient==null)
        {
            System.out.println("Patient not found with the id: " + patientId);
            return null;
        }
        System.out.println("our patient: " + patient.toString());
        return patient;
    }
}
