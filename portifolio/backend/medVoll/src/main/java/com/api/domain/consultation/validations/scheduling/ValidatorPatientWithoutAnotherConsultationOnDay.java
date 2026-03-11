package com.api.domain.consultation.validations.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.api.domain.ValidationException;
import com.api.domain.consultation.ConsultationRepository;
import com.api.domain.consultation.DetailsConsultation;

@Component
public class ValidatorPatientWithoutAnotherConsultationOnDay implements AppointmentSchedulingValidator {

    @Autowired
    private ConsultationRepository consultationRepository;

    public void validate(DetailsConsultation data) {
        var firstTime = data.date().withHour(7);
        var lastTime = data.date().withHour(18);
        var ThePatientAnotherAappointmentToday = consultationRepository
                .existsByPatientIdAndDateBetween(data.idPatient(), firstTime, lastTime);
        if (ThePatientAnotherAappointmentToday) {
            throw new ValidationException("Paciente já possui uma consulta agendada nesse dia");
        }
    }

}

