package com.api.domain.patient;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient register(Patient patient) {
        Objects.requireNonNull(patient, "Patient cannot be null");
        return patientRepository.save(patient);
    }
}