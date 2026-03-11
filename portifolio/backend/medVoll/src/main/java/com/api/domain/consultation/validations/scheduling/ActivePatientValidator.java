package com.api.domain.consultation.validations.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.api.domain.ValidationException;
import com.api.domain.consultation.DetailsConsultation;
import com.api.domain.patient.PatientRepository;

@Component
public class ActivePatientValidator implements AppointmentSchedulingValidator {

    @Autowired
    private PatientRepository patientRepository;

    public void validate(DetailsConsultation data) {
        var patientIsActive = patientRepository.findAtivoById(data.idPatient());
        if (!patientIsActive) {
            throw new ValidationException("Consulta não pode ser agendada com paciente excluído");
        }
    }
}
