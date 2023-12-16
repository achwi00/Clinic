package com.project.clinic.controller;

import com.project.clinic.entity.PatientEntity;
import com.project.clinic.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PatientController {
    private final PatientRepository patientRepository;

    @PostMapping("/patiententity")
    PatientEntity patientEntity(@RequestBody PatientEntity patientEntity){
        return patientRepository.save(patientEntity);
    }
}
