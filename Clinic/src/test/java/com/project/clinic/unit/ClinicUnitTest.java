package com.project.clinic.unit;

import com.project.clinic.Admin;
import com.project.clinic.Clinic;
import com.project.repository.AdminRepository;
import com.project.repository.ClinicRepository;
import com.project.service.AdminService;
import com.project.service.ClinicService;
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
public class ClinicUnitTest {
    @Mock
    private ClinicRepository clinicRepository;

    @InjectMocks
    private ClinicService clinicService;

    @Test
    public void testGetAllClinics(){
        List<Clinic> clinics = Arrays.asList(
            new Clinic("Kraków-Prokocim","ul. Wielicka"),
            new Clinic("Kraków-Stare Miasto","ul. Pawia"),
            new Clinic("Kraków-Bronowice","ul. Głowackiego"));
        when(clinicRepository.findAll()).thenReturn(clinics);
        List<Clinic> result = clinicService.getAllClinics();
        assertEquals (3, result.size());

    }
    @Test
    public void testGetClinicById(){
        Clinic clinic = new Clinic("Kraków-Płaszów", "ul. Lipska");
        clinic.setClinicId(5);
        when(clinicRepository.findById(Long.valueOf(5))).thenReturn(Optional.of(clinic));
        Optional<Clinic> result = clinicService.geClinicById(Long.valueOf(5));
        assertTrue(result.isPresent());
        assertEquals(clinic.getDepartmentName(), result.get().getDepartmentName());
    }
}
