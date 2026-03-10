package com.api.domain.patient;

import com.api.domain.address.Address;

public record PatientDetails(Long id, String name, String email, String cpf, String phone, Address addres) {
    
    public PatientDetails(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf(), patient.getPhone(), patient.getAddress());
    }
}
