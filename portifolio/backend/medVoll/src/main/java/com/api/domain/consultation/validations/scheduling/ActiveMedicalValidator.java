package com.api.domain.consultation.validations.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.api.domain.ValidationException;
import com.api.domain.consultation.DetailsConsultation;
import com.api.domain.doctor.DoctorRepository;

@Component
public class ActiveMedicalValidator implements AppointmentSchedulingValidator {

    @Autowired
    private DoctorRepository doctorRepository;

    public void validate(DetailsConsultation detailConsultation) {
        if (detailConsultation.idDoctor() == null) {
            return;
        }

        var doctorIsActive = doctorRepository.findAtivoById(detailConsultation.idDoctor());
        if (!doctorIsActive) {
            throw new ValidationException("Consulta não pode ser agendada com médico excluído");
        }
    }

}
