package com.api.domain.consultation.validations.cancellation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.api.domain.ValidationException;
import com.api.domain.consultation.ConsultationRepository;
import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaCancelamento")
public class AdvanceTimeValidator implements ConsultationCancellationValidator {

    @Autowired
    private ConsultationRepository repository;

    @Override
    public void validate(CancellationDataConsultation data) {
        var consultation = repository.getReferenceById(data.idConsultation());
        var now = LocalDateTime.now();
        var differenceInHours = Duration.between(now, consultation.getDate()).toHours();

        if (differenceInHours < 24) {
            throw new ValidationException("Consulta somente pode ser cancelada com antecedência mínima de 24h!");
        }
    }
}
