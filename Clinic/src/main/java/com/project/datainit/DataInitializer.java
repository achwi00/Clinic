package com.project.datainit;

import com.project.clinic.Clinic;
import com.project.repository.ClinicRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner
{
    @Autowired
    private ClinicRepository clinicRepository;

    @Override
    @Transactional
    public void run(String ... args) throws Exception
    {
        System.out.println("inside run");
        try{
            Clinic savedClinic = clinicRepository.save(new Clinic("Krk-OldTown", "Krakow"));
            System.out.println("Generated ID: " + savedClinic.getClinicId());

            //clinicRepository.save(new Clinic("Krk-OldTown","Krakow"));
        }catch(Exception e)
        {
            e.printStackTrace();
        }


    }
}
