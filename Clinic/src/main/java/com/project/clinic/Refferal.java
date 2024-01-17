package com.project.clinic;

import jakarta.persistence.*;

@Entity
public class Refferal
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reffId;

    @ManyToOne
    @JoinColumn(name = "patientId", referencedColumnName = "id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctorId", referencedColumnName = "id")
    private Doctor doctor;
    @Column(length =100, nullable = false)
    private String description;

    @Column(length =40, nullable = false)
    private String type;//specialisation of the doctor

    public Refferal(Patient patient, Doctor doctor, String description, String type)
    {
        this.patient = patient;
        this.doctor = doctor;
        this.description = description;
        this.type = type;
    }

    public Refferal(){};

    public int getReffId()
    {
        return reffId;
    }

    public void setReffId(int reffId)
    {
        this.reffId = reffId;
    }

    public Patient getPatient()
    {
        return patient;
    }

    public void setPatient(Patient patient)
    {
        this.patient = patient;
    }

    public Doctor getDoctor()
    {
        return doctor;
    }

    public void setDoctor(Doctor doctor)
    {
        this.doctor = doctor;
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
