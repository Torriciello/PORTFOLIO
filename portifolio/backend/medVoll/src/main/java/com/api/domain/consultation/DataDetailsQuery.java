package com.api.domain.consultation;

import java.time.LocalDateTime;

public record DataDetailsQuery(Long id, Long idDoctor, Long idPatient, LocalDateTime date) {
    public DataDetailsQuery(Consultation consultation) {
        this(consultation.getId(), consultation.getDoctor().getId(), consultation.getPatient().getId(),
                consultation.getDate());
    }
}
