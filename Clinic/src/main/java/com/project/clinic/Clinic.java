package com.project.clinic;

public class Clinic
{
    private int clinicId;
    private String departmentName;
    private String location;
    //listOfDoctors
    //listOfRooms

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
}
