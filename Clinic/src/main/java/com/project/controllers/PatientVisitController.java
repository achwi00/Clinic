package com.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PatientVisitController
{
    @RequestMapping("visits")
    public String returnPatientMain()
    {
        return "visits.html";
    }
}
