package com.api.domain.consultation;

import java.time.LocalDateTime;
import com.api.domain.doctor.Specialty;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record DetailsConsultation(
                Long idDoctor,

                @NotNull Long idPatient,

                @NotNull @Future LocalDateTime date,

                Specialty specialty) {
}
