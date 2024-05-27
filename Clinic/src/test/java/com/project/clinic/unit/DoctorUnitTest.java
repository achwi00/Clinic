package com.project.clinic.unit;

import com.project.clinic.Doctor;
import com.project.repository.DoctorRepository;
import com.project.service.DoctorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DoctorUnitTest {
    @Mock
    private DoctorRepository doctorRepository;
    @InjectMocks
    private DoctorService doctorService;

    @Test
    public void TestGetAllDoctors(){
        List<Doctor> doctors = Arrays.asList(
             new Doctor("doctor","adam","kowalski","onkolog","a1234","kowalski@wp.pl"),
             new Doctor("haslo","maria","kot","kardiolog","b5678","kot@gmail.com"),
             new Doctor("hslo","andrzej","pies","internista","c5566","pies@gmail.com")
        );
        when(doctorRepository.findAll()).thenReturn(doctors);
        List<Doctor> result = doctorService.getAllDoctors();
        assertEquals(3,result.size());
    }
    @Test
    public void TestGetDoctorById() {

        Doctor doctor = new Doctor("password", "John", "Doe", "Cardiology", "PWZ12345", "john.doe@example.com");
        doctor.setId(1);

        when(doctorRepository.findById(1L)).thenReturn(Optional.of(doctor));

        Optional<Doctor> result = doctorService.getDoctorById(1L);

        assertTrue(result.isPresent());
        assertEquals(doctor, result.get());
    }
    @Test
    public void TestGetAllSpecialisations() {
        List<String> specialisations = Arrays.asList("Onkolog", "Kardiolog", "Internista");

        when(doctorRepository.findDistinctSpecializations()).thenReturn(specialisations);

        List<String> result = doctorService.getAllSpecialisations();
        assertEquals(3, result.size());
        assertEquals(specialisations, result);
    }

    /*@Test
    public void TestUpdateSessionKey() {

        String newSessionKey = "newSessionKey123";
        Doctor doctor = new Doctor("password", "John", "Doe", "Cardiology", "PWZ12345", "john.doe@example.com");
        doctor.setId(1);

        when(doctorRepository.findById(1L)).thenReturn(Optional.of(doctor));

        doctorService.updateSessionKey(1L, newSessionKey);

        verify(doctorRepository, times(1)).save(doctor);
        assertEquals(newSessionKey, doctor.getSessionKey());
    }*/
}
