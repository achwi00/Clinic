package com.project.clinic;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class RecurringSchedule
{
    private DayOfWeek dayOfWeek;
    private LocalTime shiftStart;
    private LocalTime shiftEnd;
    private int visitTimeMinutes;

    public RecurringSchedule(DayOfWeek dayOfWeek, LocalTime shiftStart, LocalTime shiftEnd, int visitTimeMinutes)
    {
        this.dayOfWeek = dayOfWeek;
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
        this.visitTimeMinutes = visitTimeMinutes;
    }

    @Override
    public String toString()
    {
        return "RecurringSchedule{" +
                "dayOfWeek=" + dayOfWeek +
                ", shiftStart=" + shiftStart +
                ", shiftEnd=" + shiftEnd +
                ", visitTimeMinutes=" + visitTimeMinutes +
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
