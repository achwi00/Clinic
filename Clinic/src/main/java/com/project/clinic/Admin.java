package com.project.clinic;
public class Admin extends User
{
    public Admin(int id, String password, String name, String surname,String email) {
        super(id, password, name, surname,email);
    }

    public void addClinic(int clinicId, String departmentName, String location) {
       Clinic clinic = new Clinic(clinicId,departmentName,location);
    }
    public void deleteClinic(){

    }
}
