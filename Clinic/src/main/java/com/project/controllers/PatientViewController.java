package com.project.controllers;

import com.project.clinic.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class PatientViewController
{
    @Autowired
    private PatientApiController patientApiController;

//    @RequestMapping("patient")

//    public String returnAllPatients(@RequestParam Long patientId)
//    {
//        List<Patient> patients = patientApiController.getAllPatients();
//        return "patientPanel.html";
//    }

    @RequestMapping("patient")
    public String returnAllPatients(@RequestParam Long patientId)
    {
        Optional<Patient> patient = patientApiController.getThisPatient(patientId);
        return "patientPanel.html";
    }

}
