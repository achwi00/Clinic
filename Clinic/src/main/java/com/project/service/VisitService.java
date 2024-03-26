package com.project.service;

import com.project.clinic.Visit;
import com.project.repository.VisitRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VisitService
{
    @Autowired
    private VisitRepository visitRepository;

    public List<Visit> getAllVisits()
    {
        List<Visit> visitList = visitRepository.findAll();
        return visitList;
    }

    public List<Visit> getAllVisitsForPatient(Long patientId)
    {
        List<Visit> visits = visitRepository.findBookedVisitsForPatient(patientId);
        return visits;
    }

    public List<Visit> getAllVisitsIn(LocalDate start, LocalDate stop, String specialisation)
    {

        List<Visit> visits = visitRepository.findFreeVisitsBySpecialisationAndDate(specialisation, start, stop);
        return visits;
    }

    public List<Visit> getAllVisitsByDateAndDoctor(LocalDate date, Long doctorId)
    {

        List<Visit> visits = visitRepository.findBookedAndCompletedForDoctorByDate(date, doctorId);
        return visits;
    }

    public void bookVisitForPatient(Long patientId, Long visitId)
    {
        visitRepository.updateVisitStatusAndPatientId(visitId, patientId);
    }

    public List<Visit> getCompletedVisitsForPatient(Long patientId)
    {
        return visitRepository.findCompletedVisitsForPatient(patientId);
    }

    public List<Visit> getByPatientId(Long patientId)
    {
        return visitRepository.findByPatientId(patientId);
    }

    @Transactional
    public void cancelVisit(Long visitId)
    {
        Optional<Visit> optionalVisit = visitRepository.findById(visitId);

        optionalVisit.ifPresent(visit -> {
            visit.setStatus("FREE");
            visit.setPatient(null); // Set patient to null
            visitRepository.save(visit);
        });
    }

    public List<Visit> findVisitByDoctorId(Long doctorId)
    {
        List<Visit> visits = visitRepository.findVisitByDoctorId(doctorId);
        return visits;
    }

}
