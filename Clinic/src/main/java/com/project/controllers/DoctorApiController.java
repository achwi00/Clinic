package com.project.controllers;

import com.project.clinic.Doctor;
import com.project.clinic.Patient;
import com.project.clinic.Visit;
import com.project.repository.DoctorRepository;
import com.project.service.DoctorService;
import com.project.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorApiController
{
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private VisitService visitService;

    @GetMapping("/all")
    public Optional<Doctor> getThisDoctor(@RequestParam String sessionKey)
    {
        //System.out.println("patientId from getThisPatient is: " + );
        Long doctorId = doctorRepository.findIdBySessionKey(sessionKey);

        Optional<Doctor> doctor = doctorService.getPatientById(doctorId);
        if(doctor==null)
        {
            System.out.println("Patient not found with the id: " + doctorId);
            return null;
        }
        System.out.println("our patient: " + doctor.toString());
        return doctor;
    }

    @PostMapping("/doctor/submit-visit")
    public List<Visit> getVisitsIn(@RequestParam("workingDate") String workingDate,
                                   @RequestParam("sessionKey") String sessionKey){


        LocalDate date = LocalDate.parse(workingDate);

        List<Visit> visits = visitService.getAllVisits();
        //List<Visit> visits = visitService.getAllVisits();
        for(Visit visit : visits){
            System.out.println(visit.toString());
        }

        return visits;
    }
}
