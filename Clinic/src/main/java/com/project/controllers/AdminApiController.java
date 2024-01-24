package com.project.controllers;

import com.project.clinic.Admin;
import com.project.clinic.Clinic;
import com.project.clinic.Doctor;
import com.project.clinic.Visit;
import com.project.repository.AdminRepository;
import com.project.repository.ClinicRepository;
import com.project.repository.DoctorRepository;
import com.project.service.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

import java.util.HashSet;
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
    private ClinicDoctorService clinicDoctorService;

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
    @PostMapping("/admin/submit-doctor")
    public ResponseEntity<String> createDoctor(@RequestParam("name")String name,
                                               @RequestParam("surname") String surname,
                                               @RequestParam("email") String email,
                                               @RequestParam("password") String password,
                                               @RequestParam("PWZnr") String PWZnr,
                                               @RequestParam("specialisation") String specialisation )
        /*@RequestParam("clinicIds") Set<Long> clinicIds)*/{
        //Set<Clinic> clinics = null;
        System.out.println("email: "+ email);
        /*for (Long clinicId : clinicIds){
            System.out.println("ClinicId: " +clinicId);
            Optional<Clinic> clinicOptional = clinicRepository.findById(clinicId);
            clinicOptional.ifPresent(clinics::add);
        }*/
        //Doctor doctor = new Doctor(password,name,surname,specialisation,PWZnr,email,clinics);
        Doctor doctor = new Doctor(password,name,surname,specialisation,PWZnr,email);
        doctorRepository.save(doctor);
        return ResponseEntity.ok("You have successfully created a doctor account");
    }
    @Transactional
    @PostMapping("/admin/doctor-clinic")
    public ResponseEntity<String> createClinicDoctor(@RequestParam("doctorId") Long doctorId,
                                                     @RequestParam("clinicIds") Set<Long> clinicIds) {

        //Set<Clinic> clinics = null;
        Set<Clinic> clinics = new HashSet<>();
        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);
        Doctor doctor = optionalDoctor.orElse(new Doctor());
        for (Long clinicId : clinicIds) {
            System.out.println("ClinicId: " + clinicId);
            Optional<Clinic> clinicOptional = clinicRepository.findById(clinicId);
            if(clinicOptional.isPresent())
                clinics.add(clinicOptional.get());
            //clinicDoctorService.dodajClinicDoctor(clinicOptional,doctor);
        }
        for(Clinic clinic: clinics){
            clinicDoctorService.dodajClinicDoctor(doctor,clinic);
        }
        return ResponseEntity.ok("You have successfully created a doctor ");
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