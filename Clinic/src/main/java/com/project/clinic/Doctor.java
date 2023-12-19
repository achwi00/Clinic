package com.project.clinic;

import java.time.LocalDate;

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

    public Doctor(int id, String password, String name, String surname, String specialisation, String PWZnr,String email) {
        super(id, password, name, surname,email);
        this.specialisation = specialisation;
        this.PWZnr = PWZnr;
    }
    public Refferal writeRefferal(int reffId, Patient patient, String description, String type){
        Refferal refferal = new Refferal(reffId, patient, getName(), getSurname(), description,type);
        return refferal;
    }
    public Prescription writePrescription(int prescriptionId, String accessCode, String description, int refund, LocalDate issueDate, LocalDate expiryDate){
        Prescription prescription = new Prescription(prescriptionId, accessCode, description, refund, issueDate, expiryDate);
        return prescription;
    }
}
