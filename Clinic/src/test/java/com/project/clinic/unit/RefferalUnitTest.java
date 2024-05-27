package com.project.clinic.unit;

import com.project.clinic.Doctor;
import com.project.clinic.Patient;
import com.project.clinic.Prescription;
import com.project.clinic.Refferal;
import com.project.repository.DoctorRepository;
import com.project.repository.PatientRepository;
import com.project.repository.RefferalRepository;
import com.project.service.RefferalService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class RefferalUnitTest {
    @Mock
    private RefferalRepository refferalRepository;
    @InjectMocks
    private RefferalService refferalService;
    @Mock
    private PatientRepository patientRepository;
    @Mock
    private DoctorRepository doctorRepository;
    @Test
    public void TestGetAllRefferalsByPatientId(){
        Patient patient1 = new Patient("pass", "Paweł", "Nowak", "123456789", "pawel@gmail.com", "Kraków", "123456789", "MALE");
        patient1.setId(1);
        Patient patient2 = new Patient("pass2", "Paulina", "Rak", "11223344556", "paulina@wp.pl", "Wieliczka", "111222333", "FEMALE");
        patient2.setId(2);
        Doctor doctor = new Doctor("pass1","Anna","Nowak","kardiolog","Ns123","anna@wp.pl");
        List<Refferal> refferals = Arrays.asList(
                new Refferal(patient2,doctor,"aaaaaaaaaaaaaaaaaaaaaaa","pilny"),
                new Refferal(patient2,doctor,"bbbbbb","standardowy")
        );
        when(refferalRepository.findAllByPatientId(2L)).thenReturn(refferals);
        List<Refferal> result = refferalService.getAllRefferalsByPatientId(2L);
        assertEquals(2, result.size());

    }
    @Test
    public void TestCreateNewRefferal_Success() {
        Long doctorId = 1L;
        Long patientId = 1L;
        String type = "Cardiology";
        String description = "Patient needs to see a cardiologist";

        Doctor doctor = new Doctor("pass1", "Anna", "Nowak", "Cardiology", "Ns123", "anna@wp.pl");
        Patient patient = new Patient("pass", "Paweł", "Nowak", "123456789", "pawel@gmail.com", "Kraków", "123456789", "MALE");

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(doctor));
        when(patientRepository.findById(patientId)).thenReturn(Optional.of(patient));
        when(refferalRepository.saveAndFlush(any(Refferal.class))).thenReturn(new Refferal());

        boolean result = refferalService.createNewRefferal(doctorId, patientId, type, description);

        assertTrue(result);
        verify(refferalRepository, times(1)).saveAndFlush(any(Refferal.class));
    }

    @Test
    public void TestCreateNewRefferal_DoctorNotFound() {
        Long doctorId = 1L;
        Long patientId = 1L;
        String type = "Cardiology";
        String description = "Patient needs to see a cardiologist";

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.empty());

        boolean result = refferalService.createNewRefferal(doctorId, patientId, type, description);

        assertFalse(result);
        verify(refferalRepository, never()).saveAndFlush(any(Refferal.class));
    }

    @Test
    public void TestCreateNewRefferal_PatientNotFound() {
        Long doctorId = 1L;
        Long patientId = 1L;
        String type = "Cardiology";
        String description = "Patient needs to see a cardiologist";

        Doctor doctor = new Doctor("pass1", "Anna", "Nowak", "Cardiology", "Ns123", "anna@wp.pl");

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(doctor));
        when(patientRepository.findById(patientId)).thenReturn(Optional.empty());

        boolean result = refferalService.createNewRefferal(doctorId, patientId, type, description);

        assertFalse(result);
        verify(refferalRepository, never()).saveAndFlush(any(Refferal.class));
    }

}
