package com.project.controllers;

import com.project.clinic.Admin;
import com.project.clinic.Clinic;
import com.project.clinic.Doctor;
import com.project.clinic.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class AdminViewController {

    @Autowired
    private AdminApiController adminApiController;
    @RequestMapping("admin")
    public String returnAllAdmin(@RequestParam String sessionKey)
    {
        Optional<Admin> admin = adminApiController.getThisAdmin(sessionKey);
        return "adminPanel.html";
    }
    public List<Doctor> returnAllDoctors(@RequestParam String sessionKey)
    {
        List<Doctor> doctors = adminApiController.getAllDoctors(sessionKey);
        return doctors;
    }
    public List<Clinic> returnAllClinics(@RequestParam String sessionKey)
    {
        List<Clinic> clinics = adminApiController.getAllClinics(sessionKey);
        return clinics;
    }

    public List<Visit> returnFindVisitByDoctorId(@RequestParam Long doctorId)
    {
        List<Visit> visits = adminApiController.findVisitByDoctorId(doctorId);
        return visits;
    }


    public ResponseEntity<String> returnCreateDoctor(@RequestParam("name")String name,
                                                     @RequestParam("surname") String surname,
                                                     @RequestParam("email") String email,
                                                     @RequestParam("password") String password,
                                                     @RequestParam("PWZnr") String PWZnr,
                                                     @RequestParam("specialisation") String specialisation
            /*@RequestParam("clinicIds") Set<Long> clinicIds*/ ){
        //return adminApiController.createDoctor(name, surname, email, password,PWZnr,specialisation,clinicIds);
        return adminApiController.createDoctor(name, surname, email, password,PWZnr,specialisation);
    }
    public ResponseEntity<String> returnCreateClinicDoctor( @RequestParam("doctorId") Long doctorId,
                                                            @RequestParam("clinicIds") Set<Long> clinicIds) {
        return adminApiController.createClinicDoctor(doctorId,clinicIds);
    }
    @PostMapping("admin/logo_pm")
    public String reload(@RequestParam String sessionKey,
                         RedirectAttributes redirectAttributes){
        System.out.println("sessionKey: " + sessionKey);
        redirectAttributes.addAttribute("sessionKey", sessionKey);
        return "redirect:/admin";
    }
}