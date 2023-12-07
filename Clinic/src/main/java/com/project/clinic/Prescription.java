package com.project.clinic;

public class Prescription
{
    private int prescriptionId;
    private int accessCode; //or String? or int[] of length 4
    private String phoneNr;
    private String description;
    private int refund;
    //issueDate --DateTime? class sth like that
    //expiryDate

    public int getPrescriptionId()
    {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId)
    {
        this.prescriptionId = prescriptionId;
    }

    public int getAccessCode()
    {
        return accessCode;
    }

    public void setAccessCode(int accessCode)
    {
        this.accessCode = accessCode;
    }

    public String getPhoneNr()
    {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr)
    {
        this.phoneNr = phoneNr;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getRefund()
    {
        return refund;
    }

    public void setRefund(int refund)
    {
        this.refund = refund;
    }
}
