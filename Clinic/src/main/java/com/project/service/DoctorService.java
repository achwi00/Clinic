package com.project.service;

import com.project.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService
{
    @Autowired
    private DoctorRepository doctorRepository;

    public List<String> getAllSpecialisations(){
        return doctorRepository.findDistinctSpecializations();
    }

}
