package com.project.controllers;

import com.project.clinic.Patient;
import com.project.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/patient")
public class PatientApiController
{
    @Autowired
    private PatientService patientService;

    @GetMapping("/all")
    public List<Patient> getAllPatients()
    {
        List<Patient> patients = patientService.getAllPatients();
        return patients;
    }
}
