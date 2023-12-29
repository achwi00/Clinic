package com.project.clinic;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Prescription
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prescriptionId;
    @Column(length = 4, nullable = false)
    private String accessCode;
    @Column(length = 100, nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "patientId", referencedColumnName = "id")
    private Patient patient;
    @Column(length = 3, nullable = false)
    private int refund;
    @Column(nullable = false)
    private LocalDate issueDate;
    @Column(nullable = false)
    private LocalDate expiryDate;


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

    public Prescription(){};
    public Prescription(String accessCode, String description, int refund, LocalDate issueDate, LocalDate expiryDate, Patient patient) {
        this.accessCode = accessCode;
        this.description = description;
        this.refund = refund;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.patient = patient;
    }
}
