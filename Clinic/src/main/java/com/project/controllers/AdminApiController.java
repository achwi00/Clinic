package com.project.controllers;

import com.project.clinic.Admin;
import com.project.clinic.Clinic;
import com.project.clinic.Doctor;
import com.project.clinic.Visit;
import com.project.repository.AdminRepository;
import com.project.service.AdminService;
import com.project.service.ClinicService;
import com.project.service.DoctorService;
import com.project.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.SQLOutput;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminApiController {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AdminService adminService;
    @Autowired
    private ClinicService clinicService;
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private VisitService visitService;

    @Autowired
    HttpServletRequest request;

    @GetMapping("/alldoctors")
    public List<Doctor> getAllDoctors(@RequestParam String sessionKey)
    {
        List<Doctor> doctors = doctorService.getAllDoctors();
        return doctors;
    }
    @GetMapping("/allclinics")
    public List<Clinic> getAllClinics(@RequestParam String sessionKey) {

         List<Clinic> clinics = clinicService.getAllClinics();
         return clinics;
    }

    @GetMapping("/findvisit")
    public List<Visit> findVisitByDoctorId(@RequestParam("doctorId") Long doctorId){
        List<Visit> visits = visitService.findByDoctorId(doctorId);
        return visits;
    }
    @GetMapping("/all")
    public Optional<Admin> getThisAdmin(@RequestParam String sessionKey)
    {
        Long adminId = adminRepository.findIdBySessionKey(sessionKey);

        Optional<Admin> admin = adminService.getAdminById(adminId);
        if(admin==null)
        {
            System.out.println("Admin not found with the id: " + adminId);
            return null;
        }
        System.out.println("our admin: " + admin.toString());
        return admin;
    }

}
