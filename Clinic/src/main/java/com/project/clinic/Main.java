package com.project.clinic;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        LocalDate date;
        date = LocalDate.of(2023, 12,25);

        DayOfWeek monday = DayOfWeek.MONDAY;
        Doctor internistKate = new Doctor(1, "123", "Kate", "Smith", "internist","111", "ksmith@doc.com");
        Doctor cardiologistJane = new Doctor(2,"123", "Jane", "Moore", "cardiologist", "222", "janeMoore@doc.com");

        GeneralDailySchedule generalMon25 = new GeneralDailySchedule(date);
        DoctorSchedule kateMon25 = new DoctorSchedule(internistKate, date, generalMon25);
        kateMon25.addVisit(LocalTime.of(8,0),1);
        kateMon25.addVisit(LocalTime.of(8,30),2);


        DoctorSchedule janeMon25 = new DoctorSchedule(cardiologistJane, date, generalMon25);
        janeMon25.addVisit(LocalTime.of(8,30),3);


        ArrayList<Visit> arr = generalMon25.searchForVisitByDay(date);
        System.out.println("-----All available visits for " + date + " -----");
        arr.forEach(System.out::println);
        System.out.println("-----");

        System.out.println("\n\n");
        System.out.println("-----All available visits for " + date + " and specialisation: internist: ------");
        arr = generalMon25.searchForVisitByDayAndSpecialisation("internist", date);
        arr.forEach(System.out::println);
        System.out.println("-----");


    }

}
