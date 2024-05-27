package com.project.clinic.unit;

import com.project.clinic.Clinic;
import com.project.clinic.ClinicDoctor;
import com.project.clinic.Doctor;
import com.project.repository.ClinicDoctorRepository;
import com.project.repository.ClinicRepository;
import com.project.repository.DoctorRepository;
import com.project.service.ClinicDoctorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ClinicDoctorTest {
    @Mock
    ClinicDoctorRepository clinicDoctorRepository;
    @InjectMocks
    ClinicDoctorService clinicDoctorService;
    @Mock
    ClinicRepository clinicRepository;
    @Mock
    DoctorRepository doctorRepository;

    @Test
    public void testDodajClinicDoctor() {
        Clinic clinic = new Clinic();
        clinic.setClinicId(1);
        clinic.setDepartmentName("TestClinic");

        Doctor doctor = new Doctor("pass","Jan","Kot","kardiolog","Z12345","john.doe@example.com");
        doctor.setId(1);

        clinicDoctorService.dodajClinicDoctor(doctor, clinic);

        verify(clinicDoctorRepository, times(1)).save(any(ClinicDoctor.class));
    }
}
