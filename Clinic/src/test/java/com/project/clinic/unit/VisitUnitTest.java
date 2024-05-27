package com.project.clinic.unit;

import com.project.clinic.Doctor;
import com.project.clinic.Patient;
import com.project.clinic.Visit;
import com.project.repository.VisitRepository;
import com.project.service.VisitService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VisitUnitTest {
    @Mock
    private VisitRepository visitRepository;
    @InjectMocks
    private VisitService visitService;

    @Test
    public void TestGetAllVisits(){
        List<Visit> visits = Arrays.asList(
                new Visit(LocalDate.now(), LocalTime.now(), new Doctor(), new Patient()),
                new Visit(LocalDate.now().plusDays(1), LocalTime.now(), new Doctor(), new Patient())
        );

        when(visitRepository.findAll()).thenReturn(visits);

        List<Visit> result = visitService.getAllVisits();
        assertEquals(2, result.size());
        assertEquals(visits, result);
    }

    @Test
    public void TestGetAllVisitsForPatient(){

        List<Visit> visits = Arrays.asList(
                new Visit(LocalDate.now(), LocalTime.now(), new Doctor(), new Patient()),
                new Visit(LocalDate.now().plusDays(1), LocalTime.now(), new Doctor(), new Patient())
        );

        when(visitRepository.findBookedVisitsForPatient(1L)).thenReturn(visits);

        List<Visit> result = visitService.getAllVisitsForPatient(1L);
        assertEquals(2, result.size());
        assertEquals(visits, result);
    }
    @Test
    public void TestGetAllVisitsIn(){
        LocalDate start = LocalDate.now();
        LocalDate stop = LocalDate.now().plusDays(10);
        String specialisation = "Cardiology";

        List<Visit> visits = Arrays.asList(
                new Visit(LocalDate.now(), LocalTime.now(), new Doctor(), new Patient()),
                new Visit(LocalDate.now().plusDays(1), LocalTime.now(), new Doctor(), new Patient())
        );

        when(visitRepository.findFreeVisitsBySpecialisationAndDate(specialisation, start, stop)).thenReturn(visits);

        List<Visit> result = visitService.getAllVisitsIn(start, stop, specialisation);
        assertEquals(2, result.size());
        assertEquals(visits, result);
    }
    @Test
    public void TestGetAllVisitsByDateAndDoctor(){
        LocalDate date = LocalDate.now();
        Long doctorId = 1L;

        List<Visit> visits = Arrays.asList(
                new Visit(date, LocalTime.now(), new Doctor(), new Patient()),
                new Visit(date, LocalTime.now().plusHours(1), new Doctor(), new Patient())
        );

        when(visitRepository.findBookedAndCompletedForDoctorByDate(date, doctorId)).thenReturn(visits);

        List<Visit> result = visitService.getAllVisitsByDateAndDoctor(date, doctorId);
        assertEquals(2, result.size());
        assertEquals(visits, result);
    }
    @Test
    public void TestBookVisitForPatient(){
        Long patientId = 1L;
        Long visitId = 1L;

        doNothing().when(visitRepository).updateVisitStatusAndPatientId(visitId, patientId);

        visitService.bookVisitForPatient(patientId, visitId);

        verify(visitRepository, times(1)).updateVisitStatusAndPatientId(visitId, patientId);
    }
    @Test
    public void TestGetCompletedVisitsForPatient(){
        Long patientId = 1L;

        List<Visit> visits = Arrays.asList(
                new Visit(LocalDate.now(), LocalTime.now(), new Doctor(), new Patient()),
                new Visit(LocalDate.now().plusDays(1), LocalTime.now(), new Doctor(), new Patient())
        );

        when(visitRepository.findCompletedVisitsForPatient(patientId)).thenReturn(visits);

        List<Visit> result = visitService.getCompletedVisitsForPatient(patientId);
        assertEquals(2, result.size());
        assertEquals(visits, result);
    }
    @Test
    public void TestGetByPatientId(){
        Long patientId = 1L;

        List<Visit> visits = Arrays.asList(
                new Visit(LocalDate.now(), LocalTime.now(), new Doctor(), new Patient()),
                new Visit(LocalDate.now().plusDays(1), LocalTime.now(), new Doctor(), new Patient())
        );

        when(visitRepository.findByPatientId(patientId)).thenReturn(visits);

        List<Visit> result = visitService.getByPatientId(patientId);
        assertEquals(2, result.size());
        assertEquals(visits, result);
    }
    @Test
    public void TestCancelVisit(){
        Long visitId = 1L;

        Visit visit = new Visit(LocalDate.now(), LocalTime.now(), new Doctor(), new Patient());
        visit.setStatus("BOOKED");

        when(visitRepository.findById(visitId)).thenReturn(Optional.of(visit));

        visitService.cancelVisit(visitId);

        verify(visitRepository, times(1)).save(visit);
        assertEquals("FREE", visit.getStatus());
        assertNull(visit.getPatient());
    }
    @Test
    public void TestFindVisitByDoctorId(){
        Long doctorId = 1L;

        List<Visit> visits = Arrays.asList(
                new Visit(LocalDate.now(), LocalTime.now(), new Doctor(), new Patient()),
                new Visit(LocalDate.now().plusDays(1), LocalTime.now(), new Doctor(), new Patient())
        );

        when(visitRepository.findVisitByDoctorId(doctorId)).thenReturn(visits);

        List<Visit> result = visitService.findVisitByDoctorId(doctorId);
        assertEquals(2, result.size());
        assertEquals(visits, result);
    }
}
