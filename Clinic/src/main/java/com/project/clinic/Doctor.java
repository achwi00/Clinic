package com.project.clinic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@Entity
public class Doctor extends User
{
    @Column(length = 40, nullable = false)
    private String specialisation;

    @Column(length = 7, nullable = false)
    private String PWZnr;
    @Transient
    private ArrayList<RecurringSchedule> schedules;
    @ManyToMany(mappedBy ="doctors")
    Set<Clinic> clinics;
    public Doctor(){};
//    public Doctor(int id, String password, String name, String surname, String specialisation, String PWZnr,String email) {
//        super(id, password, name, surname,email);
//        this.specialisation = specialisation;
//        this.PWZnr = PWZnr;
//        schedules = new ArrayList<>(7);
//    }
public Doctor(String password, String name, String surname, String specialisation, String PWZnr,String email, Set<Clinic>clinics) {
    super(password, name, surname,email);
    this.specialisation = specialisation;
    this.PWZnr = PWZnr;
    schedules = new ArrayList<>(7);
    this.clinics = clinics ;
}
    public Doctor(String password, String name, String surname, String specialisation, String PWZnr,String email) {
        super(password, name, surname,email);
        this.specialisation = specialisation;
        this.PWZnr = PWZnr;
        schedules = new ArrayList<>(7);
    }
    public void addSchedule(DayOfWeek day, LocalTime start, LocalTime stop, int visitLength, Clinic clinic)
    {
        RecurringSchedule recurringSchedule = new RecurringSchedule(day, start, stop, visitLength, this, clinic);
        boolean scheduleExists = false;
        for(RecurringSchedule schedule : schedules)
        {

            if(schedule.getDayOfWeek().equals(day))
            {
                scheduleExists = true;
                System.out.println("schedule exists already");
                break;
            }
        }
        if(!scheduleExists)
        {
            schedules.add(recurringSchedule);
        }

    }
    public void printSchedules()
    {
        for (RecurringSchedule schedule : schedules)
        {
            System.out.println(schedule.toString());
        }
    }
    public void clearSchedule()
    {
        schedules.clear();
    }
    public RecurringSchedule searchForSchedule(DayOfWeek day)
    {
        RecurringSchedule sch = null;
        for(RecurringSchedule schedule : schedules)
        {
            System.out.println(schedule.toString());
            //if a schedule exists, return it
            if(schedule.getDayOfWeek().equals(day))
            {
                System.out.println("day from searchForSchedule " + schedule.getDayOfWeek());
                sch = schedule;
            }

        }
        return sch;
    }
    public String getSpecialisation()
    {
        return specialisation;
    }

    public void setSpecialisation(String specialisation)
    {
        this.specialisation = specialisation;
    }

    public String getPWZnr()
    {
        return PWZnr;
    }

    public void setPWZnr(String PWZnr)
    {
        this.PWZnr = PWZnr;
    }

    public void setClinics(Set<Clinic> clinics) {
        this.clinics = clinics;
    }
}
