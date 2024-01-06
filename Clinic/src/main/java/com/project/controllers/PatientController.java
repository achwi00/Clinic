package com.project.controllers;

import org.springframework.ui.Model;
import com.project.clinic.Patient;
import com.project.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PatientController
{
    @Autowired
    private PatientRepository patientRepository;

//    @RequestMapping("patient")
//    public String returnPatientMain()
//    {
//        return "patientPanel.html";
//    }

    @RequestMapping("patient")
    public String returnAllPatients(Model model)
    {
        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("patients",patients);
        return "patientPanel.html";
    }

}
