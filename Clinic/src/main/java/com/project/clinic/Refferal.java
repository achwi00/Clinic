package com.project.clinic;

public class Refferal
{
    private int reffId;
    private int patientId;
    private int doctorId;
    private String description;
    private String type;

    public int getReffId()
    {
        return reffId;
    }

    public void setReffId(int reffId)
    {
        this.reffId = reffId;
    }

    public int getPatientId()
    {
        return patientId;
    }

    public void setPatientId(int patientId)
    {
        this.patientId = patientId;
    }

    public int getDoctorId()
    {
        return doctorId;
    }

    public void setDoctorId(int doctorId)
    {
        this.doctorId = doctorId;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
