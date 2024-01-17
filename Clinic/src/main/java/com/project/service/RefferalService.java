package com.project.service;

import com.project.clinic.Doctor;
import com.project.clinic.Patient;
import com.project.clinic.Refferal;
import com.project.clinic.Visit;
import com.project.repository.DoctorRepository;
import com.project.repository.PatientRepository;
import com.project.repository.RefferalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefferalService
{
    @Autowired
    public RefferalRepository refferalRepository;
    @Autowired
    public PatientRepository patientRepository;
    @Autowired
    public DoctorRepository doctorRepository;

    public List<Refferal> getAllRefferalsByPatientId(Long patientId){
        return refferalRepository.findAllByPatientId(patientId);
    }

    public boolean createNewRefferal(Long doctorId, Long patientId, String type, String description){

        System.out.println("DoctorId : " + doctorId);
        System.out.println("PatientId: " + patientId);
//        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
//        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);
//        Patient patient;
//        Doctor doctor;
//        if(optionalPatient.isPresent() && optionalDoctor.isPresent()){
//            patient = optionalPatient.get();
//            doctor = optionalDoctor.get();
//            Refferal refferal = new Refferal(patient, doctor, description, type);
//            refferalRepository.save(refferal);
//
//            return true;
//        }
//        else {
//            return false;
//        }
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

        Refferal refferal = new Refferal(patient, doctor, description, type);
        refferalRepository.saveAndFlush(refferal);

        return true;
    }
}
