package com.project.clinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic
{
    private int clinicId;
    private String departmentName;
    private String location;
    private ArrayList<Doctor> listOfDoctors = new ArrayList<>();
    private List<Room> listOfRooms = new ArrayList<>();
    public int getClinicId()
    {
        return clinicId;
    }

    public void setClinicId(int clinicId)
    {
        this.clinicId = clinicId;
    }

    public String getDepartmentName()
    {
        return departmentName;
    }

    public void setDepartmentName(String departmentName)
    {
        this.departmentName = departmentName;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public Clinic(int clinicId, String departmentName, String location) {
        this.clinicId = clinicId;
        this.departmentName = departmentName;
        this.location = location;
    }
    public void hireDoctor(Doctor doctor){
        listOfDoctors.add(doctor);
    }
    public void fireDoctor(Doctor doctor)
    {
        listOfDoctors.remove(doctor);
    }
    public void addRoom(Room room){
        listOfRooms.add(room);
    }//czy nie powinnysmy gdzies wywolywac konstruktora
    //w sensie zeby podac parametry tego gabinetu: tylko gdzie. Docelowo takie rzeczy powinien robic admin/moderator?
    public void deleteRoom(Room room){
        listOfRooms.remove(room);
    }
}
