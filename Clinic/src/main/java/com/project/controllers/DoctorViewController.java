package com.project.controllers;

import com.project.clinic.Doctor;
import com.project.clinic.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class DoctorViewController
{
    @Autowired
    private DoctorApiController doctorApiController;

    @RequestMapping("doctor")
    public String returnAllDoctors(@RequestParam String sessionKey)
    {
        Optional<Doctor> doctor = doctorApiController.getThisDoctor(sessionKey);
        return "doctorPanel.html";
    }
}
