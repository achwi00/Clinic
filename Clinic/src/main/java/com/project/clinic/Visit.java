package com.project.clinic;

import java.time.LocalDate;
import java.time.LocalTime;

public class Visit
{
    private int visitId;
    private LocalDate date;
    private LocalTime time;
    private Doctor doctor;
    private Patient patient;
    private String visitDescription;
    //roomId??
    //prescriptionId??
    //clinicId??
    private enum Status{
        CANCELLED, PENDING, COMPLETED, INPROGRESS;
    }
    private Status status;

    public Status getStatus()
    {
        return status;
    }
    public void setStatus(String s)
    {
        if(s.equalsIgnoreCase("CANCELLED"))
        {
            this.status = Status.CANCELLED;
        }
        else if(s.equalsIgnoreCase("PENDING"))
        {
            this.status = Status.PENDING;
        }
        else if(s.equalsIgnoreCase("COMPLETED"))
        {
            this.status = Status.COMPLETED;
        }
        else if(s.equalsIgnoreCase("INPROGRESS"))
        {
            this.status = Status.INPROGRESS;
        }

    }


}