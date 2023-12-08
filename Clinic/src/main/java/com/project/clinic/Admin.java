package com.project.clinic;
public class Admin extends User
{
    public Admin(int id, String password, String name, String surname) {
        super(id, password, name, surname);
    }

    public void addClinic(int clinicId, String departmentName, String location) {
       Clinic clinic = new Clinic(clinicId,departmentName,location);
    }
    public void deleteClinic(){

    }
}
