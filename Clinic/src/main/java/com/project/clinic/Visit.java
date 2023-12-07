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
    private enum status{
        cancelled, pending, completed, inprogress;
    }
    //roomId??
    //prescriptionId??
    //clinicId??
}
