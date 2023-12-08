package com.project.clinic;

import java.time.LocalDate;

public class Prescription
{
    private int prescriptionId;
    private String accessCode;
    private String description;
    private String pesel;
    private int refund;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    public String getPesel()
    {
        return pesel;
    }

    public void setPesel(String pesel)
    {
        this.pesel = pesel;
    }
    public int getPrescriptionId()
    {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId)
    {
        this.prescriptionId = prescriptionId;
    }

    public String getAccessCode()
    {
        return accessCode;
    }

    public void setAccessCode(String accessCode)
    {
        this.accessCode = accessCode;
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

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Prescription(int prescriptionId, String accessCode, String description, int refund, LocalDate issueDate, LocalDate expiryDate, String pesel) {
        this.prescriptionId = prescriptionId;
        this.accessCode = accessCode;
        this.description = description;
        this.refund = refund;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.pesel = pesel;
    }
}
