package com.project.controllers;

import com.project.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController
{
    @Autowired
    public PatientRepository patientRepository;

    @RequestMapping("/")
    public String showLogin(){
        return "index.html";
    }

    @PostMapping("/login-submit")
    public String log_in(@RequestParam("email") String email,
                         @RequestParam("password") String password)
    {

        if(isValidUser(email, password)){
            return "redirect:/patient";
        }
        else{
            return "redirect:/";
        }
    }

    public boolean isValidUser(String email, String password){
        //look through Patients
        //look through doctors
        //look through admins
        //look through moderators

        //return what kind of user it is, if it is none of them, return none or sth.
        //In the log_in, check what was returned, aquire his id.
        return patientRepository.existsByEmailAndPassword(email, password);

    }
}
