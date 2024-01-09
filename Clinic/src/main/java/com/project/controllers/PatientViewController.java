package com.project.controllers;

import com.project.clinic.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("patient/logo_pm")
    public String reload(@RequestParam Long patientId,
                         RedirectAttributes redirectAttributes){
        System.out.println("patientId: " + patientId);
        redirectAttributes.addAttribute("patientId", patientId);
        return "redirect:/patient";
    }

}
