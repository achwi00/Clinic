package com.project.controllers;

import com.project.repository.DoctorRepository;
import com.project.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController
{
    @Autowired
    public PatientRepository patientRepository;

    @Autowired
    public DoctorRepository doctorRepository;

    @RequestMapping("/")
    public String showLogin(){
        return "index.html";
    }

    @PostMapping("/login-submit")
    public String log_in(@RequestParam("email") String email,
                         @RequestParam("password") String password,
                         RedirectAttributes redirectAttributes)
    {
        //redirect to doctor if he is a doctor, to admin, to moderator
        if(isValidUser(email, password).equals("patient")){
            Long patientId = patientRepository.findIdByEmailAndPassword(email, password);
            redirectAttributes.addAttribute("patientId", patientId);
            return "redirect:/patient";
        }
        else{
            return "redirect:/";
        }
    }

    public String isValidUser(String email, String password){
        //look through Patients
        //look through doctors
        //look through admins
        //look through moderators

        //return what kind of user it is, if it is none of them, return none or sth.
        //In the log_in, check what was returned, aquire his id.
        //check if user is a patient
        if(patientRepository.existsByEmailAndPassword(email, password)) return "patient";
        else if (doctorRepository.existsByEmailAndPassword(email, password)) return "doctor";
        else return "none";

    }
}
