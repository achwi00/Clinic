package com.project.service;

import com.project.clinic.Patient;
import com.project.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService
{
    @Autowired
    private PatientRepository patientRepository;


    public List<Patient> getAllPatients(){
        List<Patient> patients = patientRepository.findAll();
        return patients;
    }

    public Optional<Patient> getPatientById(Long patientId){
        return  patientRepository.findById(patientId);
    }

    public void updateSessionKey(Long patientId, String newSessionKey) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);

        optionalPatient.ifPresent(patient -> {
            // Update the sessionKey
            patient.setSessionKey(newSessionKey);

            // Save the updated patient back to the database
            patientRepository.save(patient);
        });
    }

    public void updatePassword(String email, String newPassword) {
        Patient patient = patientRepository.findByEmail(email);
        if (patient != null) {
            patient.setPassword(newPassword);
            patientRepository.save(patient);
        }
    }
    public Long findIdByPesel(String pesel)
    {
        return patientRepository.findIdByPesel(pesel);
    }
}
