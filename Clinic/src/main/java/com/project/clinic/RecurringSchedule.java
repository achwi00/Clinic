package com.project.clinic;

import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
@Entity
public class RecurringSchedule
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recurringSchId;
    @Column(nullable = false)
    private DayOfWeek dayOfWeek;
    @Column(nullable = false)
    private LocalTime shiftStart;
    @Column(nullable = false)
    private LocalTime shiftEnd;
    @Column(nullable = false)
    private int visitTimeMinutes;

    @ManyToOne
    @JoinColumn(name = "clinicId", referencedColumnName = "clinicId")
    private Clinic clinic;
    @ManyToOne
    @JoinColumn(name = "doctorId", referencedColumnName = "id")
    private Doctor doctor;
//    @ManyToOne
//    @JoinColumn(name = "clinicId")
//    private Clinic clinic;

    public RecurringSchedule(){};
    public RecurringSchedule(DayOfWeek dayOfWeek, LocalTime shiftStart, LocalTime shiftEnd, int visitTimeMinutes, Doctor doctor, Clinic clinic)
    {
        this.dayOfWeek = dayOfWeek;
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
        this.visitTimeMinutes = visitTimeMinutes;
        this.doctor = doctor;
        this.clinic = clinic;
    }

    @Override
    public String toString()
    {
        return "RecurringSchedule{" +
                "dayOfWeek=" + dayOfWeek +
                ", shiftStart=" + shiftStart +
                ", shiftEnd=" + shiftEnd +
                ", visitTimeMinutes=" + visitTimeMinutes +
                ", in clinic: " + clinic.getDepartmentName() +
                '}';
    }


    public DayOfWeek getDayOfWeek()
    {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek)
    {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getShiftStart()
    {
        return shiftStart;
    }

    public void setShiftStart(LocalTime shiftStart)
    {
        this.shiftStart = shiftStart;
    }

    public LocalTime getShiftEnd()
    {
        return shiftEnd;
    }

    public void setShiftEnd(LocalTime shiftEnd)
    {
        this.shiftEnd = shiftEnd;
    }

    public int getVisitTimeMinutes()
    {
        return visitTimeMinutes;
    }

    public void setVisitTimeMinutes(int visitTimeMinutes)
    {
        this.visitTimeMinutes = visitTimeMinutes;
    }
}
