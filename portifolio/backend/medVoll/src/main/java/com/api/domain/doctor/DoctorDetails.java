package com.api.domain.doctor;

import com.api.domain.address.Address;

public record DoctorDetails(Long id, String name, String phone, Especialidade especialidade, String cpf, String crm,
        Address address) {

    public DoctorDetails(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getPhone(), doctor.getEspecialidade(), doctor.getCpf(),
                doctor.getCrm(),
                doctor.getAddress());
    }
}
