package com.project.clinic;

import java.time.LocalDate;
import java.time.LocalTime;

public class Visit
{
    private int visitId;
    private LocalDate date;
    private LocalTime time;
    private Doctor doctor;
    private Patient patient;
    private String visitDescription;
    private enum status{
        cancelled, pending, completed, inprogress;
    }

    private Room room;

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getVisitDescription() {
        return visitDescription;
    }

    public void setVisitDescription(String visitDescription) {
        this.visitDescription = visitDescription;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void writePrescription(int prescriptionId, String accessCode, String description, int refund, LocalDate issueDate, LocalDate expiryDate){
        doctor.writePrescription(prescriptionId, accessCode, description, refund, issueDate, expiryDate);
    }
    public void writeRefferal(int reffId, String description, String type){
        doctor.writeRefferal(reffId, getPatient(), description, type);
    }
}
