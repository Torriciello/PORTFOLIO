package com.api.domain.doctor;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Page<Doctor> findAllByAtivoTrue(Pageable pageable);

    @Query("""
            select m from Doctor m
            where
            m.ativo = true
            and
            m.especialidade = :especialidade
            and
            m.id not in(
                select c.doctor.id from Consultation c
                where
                c.date = :data
                and
                c.reasonCancellation is null
            )
            order by function('random')
            limit 1
            """)
    Doctor chooseRandomFreeDoctorDate(Specialty especialidade, LocalDateTime data);

    @Query("""
            select m.ativo
            from Doctor m
            where
            m.id = :id
            """)
    Boolean findAtivoById(Long id);
}
