package com.project.clinic;

import java.time.LocalDate;
import java.util.ArrayList;

public class GeneralDailySchedule {
    LocalDate date ;
    ArrayList<DoctorSchedule> generalDailySchedule;
    public GeneralDailySchedule(LocalDate date)
    {
        this.date = date;
        this.generalDailySchedule = new ArrayList<>();
    }
    public void addSchedule(DoctorSchedule schedule)
    {
        generalDailySchedule.add(schedule);
    }
    public ArrayList<Visit> searchForVisitByDay(LocalDate date)
    {
        ArrayList<Visit> availableList = new ArrayList<>();
        for(DoctorSchedule schedule : generalDailySchedule)
        {
            availableList.addAll(schedule.searchForVisit(date));
        }
        return availableList;
    }

    public ArrayList<Visit> searchForVisitByDayAndSpecialisation(String specialisation, LocalDate date)
    {
        ArrayList<Visit> availableList = new ArrayList<>();
        for(DoctorSchedule schedule : generalDailySchedule)
        {
            if(schedule.getDoctor().getSpecialisation().equals(specialisation))
            {
                availableList.addAll(schedule.searchForVisit(date));
            }
        }
        return availableList;
    }

}
