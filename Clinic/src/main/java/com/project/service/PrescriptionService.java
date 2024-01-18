package com.project.service;

import com.project.clinic.Doctor;
import com.project.clinic.Patient;
import com.project.clinic.Prescription;
import com.project.repository.DoctorRepository;
import com.project.repository.PatientRepository;
import com.project.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService
{
    @Autowired
    private PrescriptionRepository prescriptionRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    public List<Prescription> getAllPrescriptionsByPatientId(Long patientId){
        return prescriptionRepository.findAllByPatientId(patientId);
    }

    public boolean createNewPrescription(Long doctorId, Long patientId, Number refund, String accessCode, LocalDate date, String description){
        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        Doctor doctor;
        Patient patient;

        if (optionalDoctor.isPresent()) {
            doctor = optionalDoctor.get();
        } else {
            return false;
        }

        if (optionalPatient.isPresent()) {
            patient = optionalPatient.get();
        } else {
            return false;
        }
        LocalDate issueDate = LocalDate.now();
        int ref = refund.intValue();
        Prescription prescription = new Prescription(accessCode, description, ref, issueDate, date, patient);
        prescriptionRepository.saveAndFlush(prescription);
        return true;
    }

}
