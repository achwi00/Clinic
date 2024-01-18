package com.project.controllers;

import com.project.clinic.Doctor;
import com.project.clinic.Patient;
import com.project.clinic.Visit;
import com.project.repository.DoctorRepository;
import com.project.repository.PatientRepository;
import com.project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private RefferalService refferalService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PrescriptionService prescriptionService;


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

        System.out.println("Working date: " + workingDate);
        System.out.println("SessionKey: " + sessionKey);

        Long doctorId = doctorRepository.findIdBySessionKey(sessionKey);
        LocalDate date = LocalDate.parse(workingDate);

        //List<Visit> visits = visitService.getAllVisits();
        List<Visit> visits = visitService.getAllVisitsByDateAndDoctor(date, doctorId);

        for(Visit visit : visits){
            System.out.println(visit.toString());
        }

        return visits;
    }

    @PostMapping("/doctor/submit-refferal")
    public ResponseEntity<String> submitRefferal(@RequestParam("pesel") String pesel,
                                                 @RequestParam("type")String type,
                                                 @RequestParam("description") String description,
                                                 @RequestParam("sessionKey") String sessionKey)
    {
        Long doctorId = doctorRepository.findIdBySessionKey(sessionKey);
        //Long patientId = patientService.findIdByPesel(pesel);
        Long patientId = patientRepository.findIdByPesel(pesel);
        System.out.println("DoctorId " + doctorId);
        System.out.println("PatientId: " + patientId);
        System.out.println("Pesel" + pesel);

        if(patientId==null){//that does not work
            return ResponseEntity.ok("PESEL invalid");
        }
        if((refferalService.createNewRefferal(doctorId, patientId, type, description)))
        {
            return ResponseEntity.ok("You have successfully submitted a refferal");
        }
        else{
            return ResponseEntity.ok("Pesel invalid");
        }

    }

    @PostMapping(("/doctor/submit-prescription"))
    public ResponseEntity<String> submitPrescription(@RequestParam("pesel") String pesel,
                                                     @RequestParam("refund") Number refund,
                                                     @RequestParam("accessCode") String accessCode,
                                                     @RequestParam("expiryDate") String expiryDate,
                                                     @RequestParam("description") String description,
                                                     @RequestParam("sessionKey") String sessionKey)
    {
        Long doctorId = doctorRepository.findIdBySessionKey(sessionKey);
        Long patientId = patientRepository.findIdByPesel(pesel);

        LocalDate date = LocalDate.parse(expiryDate);
        System.out.println("Pesel: " + pesel + "Refund: " + refund);
        System.out.println("Accesscode: " + accessCode + "Expiry date: " + date);
        System.out.println("PatiendId: " + patientId + "DoctorId: " + doctorId);

        if(patientId==null){//that does not work
            return ResponseEntity.ok("PESEL invalid");
        }
        else{
            if(prescriptionService.createNewPrescription(doctorId, patientId, refund, accessCode, date, description))
            {
                return ResponseEntity.ok("You have successfully submitted a prescription");
            }
            else{
                return ResponseEntity.ok("Something went wrong");
            }
        }

    }
}
