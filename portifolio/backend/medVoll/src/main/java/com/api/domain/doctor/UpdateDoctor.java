package com.api.domain.doctor;

import com.api.domain.address.DateAdress;

public record UpdateDoctor(
                Long id,
                String name,
                String phone,
                DateAdress address) {
}