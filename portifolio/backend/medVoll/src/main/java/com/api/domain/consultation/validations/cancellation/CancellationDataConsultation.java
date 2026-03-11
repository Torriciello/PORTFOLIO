package com.api.domain.consultation.validations.cancellation;

import com.api.domain.consultation.ReasonCancellation;

import jakarta.validation.constraints.NotNull;

public record CancellationDataConsultation(
        @NotNull
        Long idConsultation,

        @NotNull
        ReasonCancellation reasonCancellation) {
}
