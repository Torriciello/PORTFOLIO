package com.api.domain.patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Page<Patient> findAllByAtivoTrue(Pageable pageable);

    @Query("""
            select p.ativo
            from Patient p
            where p.id = :id
            """)
    Boolean findAtivoById(@Param("id") Long id);
}