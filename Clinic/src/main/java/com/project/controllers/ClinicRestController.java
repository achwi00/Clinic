package com.project.controllers;

import com.project.clinic.Clinic;
import com.project.repository.ClinicRepository;
import com.project.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clinic")
public class ClinicRestController {
    @Autowired
    private ClinicService clinicService;
    @Autowired
    private ClinicRepository clinicRepository;

    @GetMapping("/allClinics")
    public List<Clinic> getAllClinics() {
        return clinicService.getAllClinics();
    }
}
