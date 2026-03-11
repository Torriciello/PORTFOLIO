package com.api.domain.consultation.validations.scheduling;

import org.springframework.stereotype.Component;
import com.api.domain.ValidationException;
import com.api.domain.consultation.DetailsConsultation;
import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidatorScheduleAdvanceSchedule")
public class AdvanceTimeValidator implements AppointmentSchedulingValidator {

    public void validate(DetailsConsultation detailConsultation) {
        var dateQuery = detailConsultation.date();
        var now = LocalDateTime.now();
        var differenceInMinutes = Duration.between(now, dateQuery).toMinutes();

        if (differenceInMinutes < 30) {
            throw new ValidationException("Consulta deve ser agendada com antecedência mínima de 30 minutos");
        }

    }
}
