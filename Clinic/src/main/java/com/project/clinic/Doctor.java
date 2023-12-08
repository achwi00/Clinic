package com.project.clinic;

public class Doctor extends User
{
    private String specialisation;
    private String PWZnr;

    public String getSpecialisation()
    {
        return specialisation;
    }

    public void setSpecialisation(String specialisation)
    {
        this.specialisation = specialisation;
    }

    public String getPWZnr()
    {
        return PWZnr;
    }

    public void setPWZnr(String PWZnr)
    {
        this.PWZnr = PWZnr;
    }

    public Doctor(int id, String password, String name, String surname, String specialisation, String PWZnr) {
        super(id, password, name, surname);
        this.specialisation = specialisation;
        this.PWZnr = PWZnr;
    }
}
