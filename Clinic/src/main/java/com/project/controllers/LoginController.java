package com.project.controllers;

import com.project.clinic.Patient;
import com.project.repository.AdminRepository;
import com.project.repository.DoctorRepository;
import com.project.repository.PatientRepository;
import com.project.service.DoctorService;
import com.project.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;
import java.util.Random;

@Controller
public class LoginController
{
    @Autowired
    public PatientRepository patientRepository;

    @Autowired
    public DoctorRepository doctorRepository;

    @Autowired
    public DoctorService doctorService;

    @Autowired
    public AdminRepository adminRepository;

    @Autowired
    public PatientService patientService;

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
            String sK = generateSessionKey();
            patientService.updateSessionKey(patientId, sK);

            //redirectAttributes.addAttribute("patientId", patientId);

            //that is added:
            redirectAttributes.addAttribute("sessionKey", sK);
            return "redirect:/patient";
        }else if (isValidUser(email,password).equals("doctor")) {
            Long doctorId = doctorRepository.findIdByEmailAndPassword(email, password);
            String sK = generateSessionKey();
            doctorService.updateSessionKey(doctorId, sK);
            //redirectAttributes.addAttribute("patientId", patientId);
            //that is added:
            redirectAttributes.addAttribute("sessionKey", sK);
            return "redirect:/doctor";
        } else{
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

    public String generateSessionKey(){
        boolean doesExist= false;
        String generatedString = "";
        if(doesExist==false)
        {
            int leftLimit = 48; // numeral '0'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 20;
            Random random = new Random();

            generatedString = random.ints(leftLimit, rightLimit + 1)
                    .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

        }
        if(patientRepository.existsBySessionKey(generatedString)) doesExist=true;
        if(doctorRepository.existsBySessionKey(generatedString)) doesExist = true;
        if(adminRepository.existsBySessionKey(generatedString)) doesExist = true;
        else{
            doesExist = false;
        }

        if(doesExist) generateSessionKey();

        System.out.println("String generated: " + generatedString);
        return generatedString;
    }
}
