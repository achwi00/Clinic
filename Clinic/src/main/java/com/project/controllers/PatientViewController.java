package com.project.controllers;

import com.project.clinic.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PatientViewController
{
    @Autowired
    private PatientApiController patientApiController;

    @RequestMapping("patient")
    public String returnAllPatients()
    {
        List<Patient> patients = patientApiController.getAllPatients();
        return "patientPanel.html";
    }

}
