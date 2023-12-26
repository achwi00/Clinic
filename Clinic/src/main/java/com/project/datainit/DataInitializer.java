package com.project.datainit;

import com.project.clinic.*;
import com.project.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner
{
    @Autowired
    private ClinicRepository clinicRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ModeratorRepository moderatorRepository;

    @Override
    @Transactional
    public void run(String ... args) throws Exception
    {
        System.out.println("inside run");
        try{
            Clinic savedClinic = clinicRepository.save(new Clinic("Krk-OldTown", "Krakow"));

            patientRepository.save(new Patient("123", "Anne", "Smith", "07153659547", "asmith@gmail.com", "Maplest 3, Krk", "12536544545", "female"));
            moderatorRepository.save(new Moderator("111", "John", "Smith", savedClinic, "premiumMedMod@gmail.com"));
            adminRepository.save(new Admin("admin", "Jenny", "Woods", "jenny2@prmed.com"));
            doctorRepository.save(new Doctor("234", "Adrien", "Belle","abelle@gmail.com", "cardiology","1233654"));

            //clinicRepository.save(new Clinic("Krk-OldTown","Krakow"));
        }catch(Exception e)
        {
            e.printStackTrace();
        }


    }
}
