package com.project.clinic.unit;

import com.project.clinic.Doctor;
import com.project.clinic.Patient;
import com.project.clinic.Prescription;
import com.project.repository.DoctorRepository;
import com.project.repository.PatientRepository;
import com.project.repository.PrescriptionRepository;
import com.project.service.PrescriptionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PrescriptionUnitTest {
    @Mock
    private PrescriptionRepository prescriptionRepository;
    @InjectMocks
    private PrescriptionService prescriptionService;
    @Mock
    private PatientRepository patientRepository;
    @Mock
    private DoctorRepository doctorRepository;
    @Test
    public void TestGetAllPrescriptionsByPatientId() {
        Patient patient1 = new Patient("pass", "Paweł", "Nowak", "123456789", "pawel@gmail.com", "Kraków", "123456789", "MALE");
        patient1.setId(1);
        Patient patient2 = new Patient("pass2", "Paulina", "Rak", "11223344556", "paulina@wp.pl", "Wieliczka", "111222333", "FEMALE");
        patient2.setId(2);

        List<Prescription> prescriptionsForPatient1 = Arrays.asList(
                new Prescription("1234","aaaaaaaaaaaaaa",50,LocalDate.of(2024,03,03),LocalDate.of(2024,07,03),patient1),
                new Prescription("5678","cccccccccccccc",80,LocalDate.of(2024,02,11),LocalDate.of(2024,06,05),patient1)
        );

        List<Prescription> prescriptionsForPatient2 = Arrays.asList(
                new Prescription("2222","bbbbbbbbbbbb",20,LocalDate.of(2024,01,05),LocalDate.of(2024,05,20),patient2)
        );
        when(prescriptionRepository.findAllByPatientId(1L)).thenReturn(prescriptionsForPatient1);
        List<Prescription> result = prescriptionService.getAllPrescriptionsByPatientId(1L);
        assertEquals(2, result.size());
    }

    @Test
    public void TestCreateNewPrescription(){
        int refund = 50;
        String accessCode = "1234";
        String description = "Test prescription";
        LocalDate expiryDate = LocalDate.of(2024, 7, 3);

        Doctor doctor = new Doctor("pass1", "Anna", "Nowak", "kardiolog", "Ns123", "anna@wp.pl");
        doctor.setId(1);
        Patient patient = new Patient("pass", "Paweł", "Nowak", "123456789", "pawel@gmail.com", "Kraków", "123456789", "MALE");
        patient.setId(1);

        when(doctorRepository.findById(1L)).thenReturn(Optional.of(doctor));
        when(patientRepository.findById(1L)).thenReturn(Optional.of(patient));

        boolean result = prescriptionService.createNewPrescription(1L, 1L, refund, accessCode, expiryDate, description);

        assertTrue(result);
        verify(prescriptionRepository, times(1)).saveAndFlush(any(Prescription.class));
    }
}
