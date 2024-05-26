package com.project.clinic.unit;

import com.project.clinic.Patient;
import com.project.repository.PatientRepository;
import com.project.service.PatientService;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PatientUnitTest {
    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService;

    @Test
    public void testGetAllPatient(){
        List<Patient> patients =  Arrays.asList(
                new Patient("pass","Paweł","Nowak","123456789","pawel@gmail.com","Kraków","123456789","MALE"),
                new Patient("pass2","Paulina","Rak","11223344556","paulina@wp.pl","Wieliczka","111222333","FEMALE")
        );
        when(patientRepository.findAll()).thenReturn(patients);
        List<Patient> result = patientService.getAllPatients();
        assertEquals (2, result.size());
    }
    @Test
    public void testGetPatientById(){
        Patient patient = new Patient("pass3","Kinga","Pies","44556677889","kinga@poczta.fm","szczyrzyc 3","666000888","FEMALE");
        patient.setId(6);

        when(patientRepository.findById(6L)).thenReturn(Optional.of(patient));
        Optional<Patient> result = patientService.getPatientById(6L);
        assertTrue(result.isPresent());
        assertEquals(patient.getPesel(), result.get().getPesel());
    }
    @Test
    public void testGetPatientByPesel(){
        Patient patient = new Patient("pass4", "Mariusz","Mysz","11188899900","mariusz@wp.pl","Dobczyce 34","222000888","MALE");
        patient.setId(7);

        when(patientRepository.findIdByPesel("11188899900")).thenReturn((long) patient.getId());
        Long result = patientService.findIdByPesel("11188899900");
        assertEquals(patient.getId(), result);
    }
}
