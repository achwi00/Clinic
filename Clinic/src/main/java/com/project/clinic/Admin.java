package com.project.clinic;

import jakarta.persistence.Entity;

@Entity
public class Admin extends User
{
    public Admin(int id, String password, String name, String surname,String email) {
        super(id, password, name, surname,email);
    }
    public Admin(){};
    public void addClinic(int clinicId, String departmentName, String location) {
       //Clinic clinic = new Clinic(clinicId,departmentName,location);
        Clinic clinic = new Clinic(departmentName,location);
    }
    public void deleteClinic(){

    }
}
