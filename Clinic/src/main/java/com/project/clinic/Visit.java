package com.project.clinic;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Visit
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int visitId;
    private LocalDate date;
    private LocalTime time;
    @ManyToOne
    @JoinColumn(name = "doctorId", referencedColumnName = "id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "clinicId", referencedColumnName = "clinicId")
    private Clinic clinic;

    @ManyToOne
    @JoinColumn(name = "patientId", referencedColumnName = "id")
    private Patient patient;
    @Column(length = 255)
    private String visitDescription;
    //roomId??
    //prescriptionId??
    //clinicId??

    private enum Status{
        CANCELLED, PENDING, COMPLETED, INPROGRESS, FREE, BOOKED;
    }

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
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
        else if (s.equalsIgnoreCase("FREE")) {
            this.status = Status.FREE;
        }
        else if (s.equalsIgnoreCase("BOOKED")) {
            this.status = Status.BOOKED;
        }

    }
    public String getStatus()
    {
        String stat = null;
        if(this.status.equals(Status.FREE))
        {
            stat="FREE";
        }
        else if(status.equals(Status.BOOKED))
        {
            stat="BOOKED";
        }
        else if(status.equals(Status.CANCELLED))
        {
            stat="CANCELLED";
        }
        else if(status.equals(Status.PENDING))
        {
            stat="PENDING";
        }
        else if(status.equals(Status.COMPLETED))
        {
            stat="COMPLETED";
        }else if(status.equals(Status.INPROGRESS))
        {
            stat="INPROGRESS";
        }

        return stat;
    }

    @Override
    public String toString()
    {
        return "Visit{" +
                "visitId=" + visitId +
                ", date=" + date +
                ", time=" + time +
                ", doctor=" + doctor.getName() +
                ", doctors's surname = " + doctor.getSurname()+
//                ", patient's name=" + patient.getName() +
//                ", patient's surname = " + patient.getSurname()+
                ", visitDescription='" + visitDescription + '\'' +
                ", status=" + getStatus() +
                '}';
    }
    public Visit(){};
    public Visit(LocalDate date, LocalTime time, Doctor doctor, Patient patient)
    {
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        this.patient = patient;
        this.status = Status.FREE;
    }


    public int getVisitId()
    {
        return visitId;
    }

    public void setVisitId(int visitId)
    {
        this.visitId = visitId;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public LocalTime getTime()
    {
        return time;
    }

    public void setTime(LocalTime time)
    {
        this.time = time;
    }

    public Doctor getDoctor()
    {
        return doctor;
    }

    public void setDoctor(Doctor doctor)
    {
        this.doctor = doctor;
    }

    public Patient getPatient()
    {
        return patient;
    }

    public void setPatient(Patient patient)
    {
        this.patient = patient;
    }

    public String getVisitDescription()
    {
        return visitDescription;
    }

    public void setVisitDescription(String visitDescription)
    {
        this.visitDescription = visitDescription;
    }

    public Clinic getClinic()
    {
        return clinic;
    }

    public void setClinic(Clinic clinic)
    {
        this.clinic = clinic;
    }
}