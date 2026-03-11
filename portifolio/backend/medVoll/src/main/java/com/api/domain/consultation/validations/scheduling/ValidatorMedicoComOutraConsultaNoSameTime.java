package com.api.domain.consultation.validations.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.api.domain.ValidationException;
import com.api.domain.consultation.ConsultationRepository;
import com.api.domain.consultation.DetailsConsultation;

@Component
public class ValidatorMedicoComOutraConsultaNoSameTime implements AppointmentSchedulingValidator {

    @Autowired
    private ConsultationRepository consultationRepository;

    public void validate(DetailsConsultation data) {
        var doctorHasAnotherConsultationAtTheSameTime = consultationRepository
                .existsByDoctorIdAndDateAndReasonCancellationIsNull(data.idDoctor(), data.date());
        if (doctorHasAnotherConsultationAtTheSameTime) {
            throw new ValidationException("Médico já possui outra consulta agendada nesse mesmo horário");
        }
    }

}
