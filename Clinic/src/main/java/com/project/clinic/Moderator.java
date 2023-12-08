package com.project.clinic;

public class Moderator extends User
{
    //private int clinicId;
    private Clinic clinic;

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public Moderator(int id, String password, String name, String surname, Clinic clinic,String email) {
        super(id, password, name, surname, email);
        this.clinic = clinic;
    }
    public void addDoctor(Doctor doctor){
        clinic.hireDoctor(doctor);
    }
    public void deleteDoctor(Doctor doctor){
        clinic.fireDoctor(doctor);
    }
    public void resetUDoctorPassword(Doctor doctor,String password){
        doctor.setPassword(password);
    }
}
