package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.domain.patient.Patient;
import com.api.domain.patient.PatientDetails;
import com.api.domain.patient.PatientService;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RequestMapping("/patients")
@RestController
@SecurityRequirement(name = "bearer-key")
public class PacienteController {

    @Autowired
    private PatientService pacienteService;

    @PostMapping("/register")
    public ResponseEntity<PatientDetails> register(@RequestBody @Valid Patient patient) {
        Patient novoPaciente = pacienteService.register(patient);
        return ResponseEntity.ok(new PatientDetails(novoPaciente));
    }

    // @GetMapping("/{id}")
    // public ResponseEntity listar(@PathVariable Long id) {
    // var paciente = pacienteService.getReferenceById(id);
    // return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    // }

    // @GetMapping
    // public ResponseEntity<Page<Patient>> listar(
    // @PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao) {
    // var page =
    // pacienteService.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    // return ResponseEntity.ok(page);
    // }

    // @PutMapping
    // @Transactional
    // public ResponseEntity atualizar(@RequestBody @Valid UpdatePatient
    // updatePatient) {
    // var paciente = pacienteService.getReferenceById(updatePatient.id());
    // paciente.atualizarInformacoes(updatePatient);

    // return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    // }

    // @DeleteMapping("/{id}")
    // @Transactional
    // public ResponseEntity excluir(@PathVariable Long id) {
    // var paciente = pacienteService.getReferenceById(id);
    // paciente.excluir();
    // return ResponseEntity.noContent().build();
    // }

}