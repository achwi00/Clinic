package com.project.clinic;

public class Patient
{
    private String pesel;
    private String phoneNr;
    private String email;
    private String passportNr;
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

    public String getPassportNr()
    {
        return passportNr;
    }

    public void setPassportNr(String passportNr)
    {
        this.passportNr = passportNr;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

}
