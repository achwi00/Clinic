package com.project.clinic;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name="Clinic")
public class Clinic
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clinicId;
    @Column(length = 50, nullable = false)
    private String departmentName;
    @Column(length = 50, nullable = false)
    private String location;
    @Transient
    private ArrayList<Doctor> listOfDoctors = new ArrayList<>();
    @Transient
    private List<Room> listOfRooms = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "clinic_doctor",
            joinColumns = @JoinColumn(name = "clinicId"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
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

    public Clinic(){};

    public Clinic( String departmentName, String location) {
        //this.clinicId = clinicId;
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
