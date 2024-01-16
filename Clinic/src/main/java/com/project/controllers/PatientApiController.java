package com.project.controllers;

import com.project.clinic.*;
import com.project.service.*;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import com.project.repository.PatientRepository;
import com.project.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/patient")
public class PatientApiController
{
    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private VisitService visitService;

    @Autowired
    private RefferalService refferalService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    HttpServletRequest request;


    @GetMapping("/all")
    public Optional<Patient> getThisPatient(@RequestParam String sessionKey)
    {
        //System.out.println("patientId from getThisPatient is: " + );
        Long patientId = patientRepository.findIdBySessionKey(sessionKey);

        Optional<Patient> patient = patientService.getPatientById(patientId);
        if(patient==null)
        {
            System.out.println("Patient not found with the id: " + patientId);
            return null;
        }
        System.out.println("our patient: " + patient.toString());
        return patient;
    }


    @GetMapping("/allvisits")
    public List<Visit> getAllVisits(@RequestParam String sessionKey)
    {
        //List<Visit> visits = visitService.getAllVisits();
        Long patientId = patientRepository.findIdBySessionKey(sessionKey);
        List<Visit> visits = visitService.getAllVisitsForPatient(patientId);
        return visits;
    }

    @GetMapping("/allrefferals")
    public List<Refferal> getAllRefferals(@RequestParam String sessionKey){

        Long patientId = patientRepository.findIdBySessionKey(sessionKey);

        List<Refferal> refferals = refferalService.getAllRefferalsByPatientId(patientId);
        return refferals;
    }

    @GetMapping("/allprescriptions")
    public List<Prescription> getAllPrescriptions(@RequestParam String sessionKey){
        Long patientId = patientRepository.findIdBySessionKey(sessionKey);
        List<Prescription> prescriptions = prescriptionService.getAllPrescriptionsByPatientId(patientId);
        return prescriptions;
    }

    @GetMapping("/allhistory")
    public List<Visit> getHistory(@RequestParam String sessionKey){
        Long patientId = patientRepository.findIdBySessionKey(sessionKey);
        List<Visit> visits = visitService.getCompletedVisitsForPatient(patientId);
        return visits;
    }

    @GetMapping("/allspecializations")
    public List<String> getAllSpecializations()
    {
        List<String> specializations = doctorService.getAllSpecialisations();
        return specializations;
    }

    @PostMapping("/patient/submit-visit")
    public List<Visit> getVisitsIn(@RequestParam("startDateIn") String startDateIn,
                                   @RequestParam("endDateIn") String endDateIn,
                                    @RequestParam("specializationIn") String specializationIn){

        LocalDate startDate = LocalDate.parse(startDateIn);
        LocalDate endDate = LocalDate.parse(endDateIn);

        //Date start = Date.valueOf(startDate);
        //Date end = Date.valueOf(endDate);
        //System.out.println(start + specializationIn + end);

        List<Visit> visits = visitService.getAllVisitsIn(startDate, endDate, specializationIn);
        //List<Visit> visits = visitService.getAllVisits();
        for(Visit visit : visits){
            System.out.println(visit.toString());
        }

        return visits;
    }

    @PostMapping("/patient/submit-visit/submit-bookVisit")
    public ResponseEntity<String> bookVisit(@RequestParam("visId") Long visId,
                            @RequestParam("sessionKey") String sessionKey){
        Long patientId = patientRepository.findIdBySessionKey(sessionKey);
        visitService.bookVisitForPatient(patientId, visId);

        return ResponseEntity.ok("You have successfully booked a visit");
    }



}
