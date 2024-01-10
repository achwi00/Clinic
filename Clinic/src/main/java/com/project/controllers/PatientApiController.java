package com.project.controllers;

import com.project.clinic.Patient;
import com.project.clinic.Refferal;
import com.project.clinic.Visit;
import com.project.repository.PatientRepository;
import com.project.repository.VisitRepository;
import com.project.service.PatientService;
import com.project.service.RefferalService;
import com.project.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
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

//    @GetMapping("/allvisits")
//    public List<Visit> getAllVisits(@RequestParam Long patientId)
//    {
//        List<Visit> visits = visitService.getAllVisits();
//        return visits;
//    }

    @GetMapping("/allvisits")
    public List<Visit> getAllVisits(@RequestParam String sessionKey)
    {
        List<Visit> visits = visitService.getAllVisits();
        return visits;
    }

    @GetMapping("/allrefferals")
    public List<Refferal> getAllRefferals(@RequestParam String sessionKey){

        Long patientId = patientRepository.findIdBySessionKey(sessionKey);

        List<Refferal> refferals = refferalService.getAllRefferalsByPatientId(patientId);
        return refferals;
    }

}
