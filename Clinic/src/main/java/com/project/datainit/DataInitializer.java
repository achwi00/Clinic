package com.project.datainit;

import com.project.clinic.*;
import com.project.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

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

    @Autowired
    private VisitRepository visitRepository;
    @Autowired
    private RecurringScheduleRepository recurringScheduleRepository;
    @Autowired
    private DoctorScheduleRepository doctorScheduleRepository;
    @Autowired
    private GeneralDailyScheduleRepository generalDailyScheduleRepository;

    @Autowired
    private RefferalRepository refferalRepository;

    @Override
    @Transactional
    public void run(String ... args) throws Exception
    {
        System.out.println("inside run");
        try{
//            Clinic savedClinic = clinicRepository.save(new Clinic("Krk-OldTown", "Krakow"));
//
//            Patient p = patientRepository.save(new Patient("123", "Anne", "Smith", "07153659547", "asmith@gmail.com", "Maplest 3, Krk", "12536544545", "female"));
//            moderatorRepository.save(new Moderator("111", "John", "Smith", savedClinic, "premiumMedMod@gmail.com"));
//            adminRepository.save(new Admin("admin", "Jenny", "Woods", "jenny2@prmed.com"));
//            Doctor d = doctorRepository.save(new Doctor("1212", "Maciej", "Nowak","internist", "1214425","mnowak@gmail.com"));
//            visitRepository.save(new Visit(LocalDate.of(2023,12,1), LocalTime.of(12,0),d, p));
//
//            RecurringSchedule recurringSchedule = recurringScheduleRepository.save(new RecurringSchedule(DayOfWeek.MONDAY, LocalTime.of(8,0),LocalTime.of(12,0),30,d,savedClinic));
//            GeneralDailySchedule genSch = generalDailyScheduleRepository.save(new GeneralDailySchedule(LocalDate.of(2024,1,1)));
//            DoctorSchedule doctorSchedule = doctorScheduleRepository.save(new DoctorSchedule(d, LocalDate.of(2024,1,1),genSch,savedClinic));
//

        }catch(Exception e)
        {
            e.printStackTrace();
        }


    }
}
