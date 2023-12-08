package com.project.clinic;

public class Patient extends User
{
    private String pesel;
    private String phoneNr;
    private String email;
    private String address;
    private enum sex{
        MALE, FEMALE
    };

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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Patient(int id, String password, String name, String surname, String pesel, String phoneNr, String email, String address) {
        super(id, password, name, surname);
        this.pesel = pesel;
        this.phoneNr = phoneNr;
        this.email = email;
        this.address = address;
    }

    public Patient(int id, String password, String name, String surname, String pesel, String email, String address) {
        super(id, password, name, surname);
        this.pesel = pesel;
        this.email = email;
        this.address = address;
    }
}
