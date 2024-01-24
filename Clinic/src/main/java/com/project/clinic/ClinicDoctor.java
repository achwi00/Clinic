package com.project.clinic;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name  = "clinic_doctor")
public class ClinicDoctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ClinicDoctorId;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Long getClinicDoctorId() {
        return ClinicDoctorId;
    }

    public void setClinicDoctorId(Long clinicDoctorId) {
        ClinicDoctorId = clinicDoctorId;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public ClinicDoctor(Clinic clinic, Doctor doctor) {
        this.clinic = clinic;
        this.doctor = doctor;
    }

    public ClinicDoctor() {
    }
}
