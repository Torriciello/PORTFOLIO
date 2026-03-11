package com.api.domain.consultation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.domain.ValidationException;
import com.api.domain.consultation.validations.cancellation.CancellationDataConsultation;
import com.api.domain.consultation.validations.cancellation.ConsultationCancellationValidator;
import com.api.domain.consultation.validations.scheduling.AppointmentSchedulingValidator;
import com.api.domain.doctor.Doctor;
import com.api.domain.doctor.DoctorRepository;
import com.api.domain.patient.PatientRepository;

import java.util.List;

@Service
public class AppointmentSchedule {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private List<AppointmentSchedulingValidator> validators;

    @Autowired
    private List<ConsultationCancellationValidator> validatorsCancellation;

    public DataDetailsQuery schedule(DetailsConsultation data) {
        if (!patientRepository.existsById(data.idPatient())) {
            throw new ValidationException("Id do paciente informado não existe!");
        }

        if (data.idDoctor() != null && !doctorRepository.existsById(data.idDoctor())) {
            throw new ValidationException("Id do médico informado não existe!");
        }

        validators.forEach(v -> v.validate(data));

        var patient = patientRepository.getReferenceById(data.idPatient());
        var doctor = chooseDoctor(data);
        if (doctor == null) {
            throw new ValidationException("Não existe médico disponível nessa data!");
        }

        var consultation = new Consultation(null, doctor, patient, data.date(), null);
        consultationRepository.save(consultation);

        return new DataDetailsQuery(consultation);
    }

    public void cancel(CancellationDataConsultation data) {
        if (!consultationRepository.existsById(data.idConsultation())) {
            throw new ValidationException("Id da consulta informado não existe!");
        }

        validatorsCancellation.forEach(v -> v.validate(data));

        var consultation = consultationRepository.getReferenceById(data.idConsultation());
        consultation.cancel(data.reasonCancellation());
    }

    private Doctor chooseDoctor(DetailsConsultation data) {
        if (data.idDoctor() != null) {
            return doctorRepository.getReferenceById(data.idDoctor());
        }

        if (data.specialty() == null) {
            throw new ValidationException("Especialidade é obrigatória quando médico não for escolhido!");
        }

        return doctorRepository.chooseRandomFreeDoctorDate(data.specialty(), data.date());
    }

}
