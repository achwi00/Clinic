package com.project.clinic;

import jakarta.persistence.*;

@Entity
public class Patient extends User
{
    private String pesel;
    private String phoneNr;
    private String address;
    private enum Sex{
        MALE, FEMALE
    };
    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private Sex sex;
    public void setSex(String s)
    {
        if(s.equalsIgnoreCase("MALE"))
        {
            this.sex = Sex.MALE;
        }
        else if(s.equalsIgnoreCase("FEMALE"))
        {
            this.sex = Sex.FEMALE;
        }
    }

    //refferalHistory list
    //prescriptionHistory list
    //historyOfVisits

    public String getPesel()
    {
        return pesel;
    }

    public void setPesel(String pesel)
    {
        this.pesel = pesel;
    }

    public String getPhoneNr()
    {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr)
    {
        this.phoneNr = phoneNr;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
    public Patient(){};
    public Patient(int id, String password, String name, String surname, String pesel, String phoneNr, String email, String address) {
        super(id, password, name, surname,email);
        this.pesel = pesel;
        this.phoneNr = phoneNr;
        this.address = address;
    }

    public Patient(int id, String password, String name, String surname, String pesel, String email, String address) {
        super(id, password, name, surname,email);
        this.pesel = pesel;
        this.address = address;
    }
}
