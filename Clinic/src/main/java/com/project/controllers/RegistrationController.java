package com.project.controllers;

import com.project.clinic.Patient;
import com.project.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController
{
    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping("register")
    public String showRegister(){
        return "register.html";
    }

    @Transactional
    @PostMapping("/submit")
    public String createPatient(@RequestParam("email") String email,
                                @RequestParam("password") String password,
                                @RequestParam("pesel") String pesel,
                                @RequestParam("sex") String sex,
                                @RequestParam("name") String name,
                                @RequestParam("surname") String surname,
                                @RequestParam("address") String address,
                                @RequestParam("phonenumber") String phonenumber) {
        Patient patient = new Patient(password, name, surname,pesel, email, address, phonenumber, sex);
        patientRepository.save(patient);
        return "redirect:/accountCreated";
    }
}
