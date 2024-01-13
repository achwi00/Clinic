package com.project.controllers;

import com.project.clinic.Admin;
import com.project.clinic.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {

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
    /*public String returnAdminMain()
    {
        return "adminPanel.html";
    }*/
    @PostMapping("admin/logo_pm")
    public String reload(@RequestParam String sessionKey,
                         RedirectAttributes redirectAttributes){
        System.out.println("sessionKey: " + sessionKey);
        redirectAttributes.addAttribute("sessionKey", sessionKey);
        return "redirect:/admin";
    }
}
