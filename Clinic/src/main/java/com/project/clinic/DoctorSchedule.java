package com.project.clinic;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DoctorSchedule
{
    private Doctor doctor;
    private LocalDate date;
    GeneralDailySchedule generalSchedule;
    private ArrayList<Visit> visits;

    public DoctorSchedule(Doctor doctor, LocalDate date, GeneralDailySchedule generalSchedule)
    {
        this.doctor = doctor;
        this.date = date;
        //add to general schedule
        generalSchedule.addSchedule(this);
        visits = new ArrayList<Visit>();
    }

    public void addVisit(LocalTime time, int visitId)
    {
        //right now patient is null because the status of the visit is FREE
        Visit visit = new Visit(visitId, getDate(), time, getDoctor(), null );
        visits.add(visit);
    }
    public ArrayList<Visit> searchForVisit(LocalDate date)
    {
        ArrayList<Visit> availableVisits = new ArrayList<>();
        for(Visit v : visits)//search in all the visits
        {
            if(v.getStatus().equals("FREE")) availableVisits.add(v); //add the free visit to available ones
        }
//        for(Visit v : availableVisits)
//        {
//            System.out.println(v.toString());
//        }
        return availableVisits;//return the list of available visits
    }

    public Doctor getDoctor()
    {
        return doctor;
    }

    public void setDoctor(Doctor doctor)
    {
        this.doctor = doctor;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }
}