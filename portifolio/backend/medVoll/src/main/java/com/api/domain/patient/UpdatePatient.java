package com.api.domain.patient;

import com.api.domain.address.DateAdress;

public record UpdatePatient(
        Long id,
        String name,
        String telefone,
        DateAdress address
) {
}