package com.api.domain.consultation.validations.scheduling;

import org.springframework.stereotype.Component;

import com.api.domain.ValidationException;
import com.api.domain.consultation.DetailsConsultation;

import java.time.DayOfWeek;

@Component
public class ValidatorOperatingHoursClinic implements AppointmentSchedulingValidator {

    public void validate(DetailsConsultation data) {
        var dataConsulta = data.date();

        var sunday = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var beforeTheClinicOpening = dataConsulta.getHour() < 7;
        var afterTheClinicClosure = dataConsulta.getHour() > 18;
        if (sunday || beforeTheClinicOpening || afterTheClinicClosure) {
            throw new ValidationException("Consulta fora do horário de funcionamento da clínica");
        }

    }

}
