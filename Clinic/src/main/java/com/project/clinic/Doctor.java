package com.project.clinic;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

public class Doctor extends User
{
    private String specialisation;
    private String PWZnr;
    private ArrayList<RecurringSchedule> schedules;

    public Doctor(int id, String password, String name, String surname, String specialisation, String PWZnr,String email) {
        super(id, password, name, surname,email);
        this.specialisation = specialisation;
        this.PWZnr = PWZnr;
        schedules = new ArrayList<>(7);
    }
    public void addSchedule(DayOfWeek day, LocalTime start, LocalTime stop, int visitLength)
    {
        RecurringSchedule recurringSchedule = new RecurringSchedule(day, start, stop, visitLength);
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

}
