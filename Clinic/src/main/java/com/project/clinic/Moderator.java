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

    public Moderator(int id, String password, String name, String surname, Clinic clinic) {
        super(id, password, name, surname);
        this.clinic = clinic;
    }
    public void addDoctor(Doctor doctor){
        clinic.hireDoctor(doctor);
    }
    public void deleteDoctor(Doctor doctor){
        clinic.fireDoctor(doctor);
    }
    public void resetUserPassword(Patient patient,String password){
        patient.setPassword(password);
    } //nie wiem czy wystarczy w taki sposób?
}
