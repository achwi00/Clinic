package com.project.clinic;

public class Refferal
{
    private int reffId;
    private Patient patient;
    private String doctorName;
    private String doctorSurname;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorSurname() {
        return doctorSurname;
    }

    public void setDoctorSurname(String doctorSurname) {
        this.doctorSurname = doctorSurname;
    }

    public Refferal(int reffId, Patient patient, String doctorName, String doctorSurname, String description, String type) {
        this.reffId = reffId;
        this.patient = patient;
        this.doctorName = doctorName;
        this.doctorSurname = doctorSurname;
        this.description = description;
        this.type = type;
    }
}
