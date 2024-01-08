package com.project.controllers;

import com.project.clinic.Patient;
import com.project.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientsTestController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patient")
    @ResponseBody
    public String getPatients() {
        List<Patient> patients = patientRepository.findAll();
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body>");
        for(Patient patient : patients){
         sb.append("<p>").append(patient.getName()).append(" ").append(patient.getSurname()).append("</p>"); }
        sb.append("</body></html>");
        return sb.toString();
    }

}
