package com.api.domain.doctor;

import java.util.Objects;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor register(Doctor doctor) {
        Objects.requireNonNull(doctor, "Patient cannot be null");
        return doctorRepository.save(doctor);
    }

    public Doctor getReferenceById(Long id) {
        return doctorRepository.getReferenceById(id);
    }

    public Page<Doctor> findAllByAtivoTrue(Pageable pageable) {
        return doctorRepository.findAllByAtivoTrue(pageable);
    }

}