package com.api.domain.doctor;

import com.api.domain.address.Address;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctors")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Valid
    private Especialidade especialidade;

    private String name;

    private String cpf;

    private String crm;

    private String phone;

    private Boolean ativo;

    @Embedded
    @NotNull(message = "O endereço é obrigatório")
    @Valid
    private Address address;

    public Doctor(DoctorDetails doctorDetails) {
        this.ativo = true;
        this.name = doctorDetails.name();
        this.phone = doctorDetails.phone();
        this.crm = doctorDetails.crm();
        this.especialidade = doctorDetails.especialidade();
        this.address = new Address();
    }

    public void update(UpdateDoctor updateDoctor) {
        if (updateDoctor.name() != null) {
            this.name = updateDoctor.name();
        }
        if (updateDoctor.phone() != null) {
            this.phone = updateDoctor.phone();
        }
        if (updateDoctor.address() != null) {
            this.address.updateAdress(address);
        }
    }

    public void excluir() {
        this.ativo = false;
    }

}
