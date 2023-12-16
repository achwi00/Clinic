package com.project.clinic.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String pesel;
    @Column
    private String phoneNr;
    @Column
    private String address;
}
