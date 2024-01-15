package com.project.controllers;

import com.project.clinic.Admin;
import com.project.clinic.Clinic;
import com.project.clinic.Doctor;
import com.project.clinic.Visit;
import com.project.repository.AdminRepository;
import com.project.repository.ClinicRepository;
import com.project.repository.DoctorRepository;
import com.project.service.AdminService;
import com.project.service.ClinicService;
import com.project.service.DoctorService;
import com.project.service.VisitService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.SQLOutput;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    private ClinicRepository clinicRepository;

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DoctorRepository doctorRepository;

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
         for(Clinic clinic:clinics){
             System.out.println(clinic.toString());
         }
         return clinics;
    }

    @PostMapping("/submit-visit")
    public List<Visit> findVisitByDoctorId(@RequestParam("doctorId") Long doctorId){
        List<Visit> visits = visitService.findVisitByDoctorId(doctorId);
        for(Visit visit : visits){
            System.out.println(visit.toString());
        }
        return visits;
    }


    @Transactional
    @PostMapping("/submit-doctor")
    public ResponseEntity<String> createDoctor(@RequestParam("name")String name,
                                               @RequestParam("surname") String surname,
                                               @RequestParam("email") String email,
                                               @RequestParam("password") String password,
                                               @RequestParam("PWZnr") String PWZnr,
                                               @RequestParam("specialisation") String specialisation,
                                               @RequestParam("clinicIds") Set<Long> clinicIds){
        Set<Clinic> clinics = null;
        for (Long clinicId : clinicIds){
            Optional<Clinic> clinicOptional = clinicRepository.findById(clinicId);
            clinicOptional.ifPresent(clinics::add);
        }
        Doctor doctor = new Doctor(password,name,surname,specialisation,PWZnr,email,clinics);
        doctorRepository.save(doctor);

        return ResponseEntity.ok("You have successfully create a doctor account");
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
