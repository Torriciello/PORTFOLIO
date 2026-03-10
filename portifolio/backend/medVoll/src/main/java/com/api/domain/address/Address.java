package com.api.domain.address;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String cep;
    private String publicPlace;
    private String number;
    private String complement;
    private String neighborhood;
    private String locality;
    private String uf;
    private String city;

    public Address(DateAdress dateAdress) {
        this.publicPlace = dateAdress.publicPlace();
        this.neighborhood = dateAdress.neighborhood();
        this.cep = dateAdress.cep();
        this.uf = dateAdress.uf();
        this.locality = dateAdress.city();
        this.number = dateAdress.number();
        this.complement = dateAdress.complement();
    }

    public void updateAdress(Address address) {
        if (address.getPublicPlace() != null) {
            this.publicPlace = address.getPublicPlace();
        }
        if (address.getNeighborhood() != null) {
            this.neighborhood = address.getNeighborhood();
        }
        if (address.getCep() != null) {
            this.cep = address.getCep();
        }
        if (address.getUf() != null) {
            this.uf = address.getUf();
        }
        if (address.getCity() != null) {
            this.city = address.getCity();
        }
        if (address.getNumber() != null) {
            this.number = address.getNumber();
        }
        if (address.getComplement() != null) {
            this.complement = address.getComplement();
        }
    }
}