package com.api.domain.consultation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import com.api.domain.doctor.Doctor;
import com.api.domain.patient.Patient;

@Table(name = "consultations")
@Entity(name = "Consultation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private LocalDateTime date;

    @Column(name = "reason_cancellation")
    @Enumerated(EnumType.STRING)
    private ReasonCancellation reasonCancellation;

    public void cancel(ReasonCancellation reason) {
        this.reasonCancellation = reason;
    }

}
