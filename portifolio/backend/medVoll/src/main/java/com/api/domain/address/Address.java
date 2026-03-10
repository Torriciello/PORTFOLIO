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
    
    public void updateAdress(DateAdress dateAdress) {
        if (dateAdress.publicPlace() != null) {
            this.publicPlace = dateAdress.publicPlace();
        }
        if (dateAdress.neighborhood() != null) {
            this.neighborhood = dateAdress.neighborhood();
        }
        if (dateAdress.cep() != null) {
            this.cep = dateAdress.cep();
        }
        if (dateAdress.uf() != null) {
            this.uf = dateAdress.uf();
        }
        if (dateAdress.city() != null) {
            this.city = dateAdress.city();
        }
        if (dateAdress.number() != null) {
            this.number = dateAdress.number();
        }
        if (dateAdress.complement() != null) {
            this.complement = dateAdress.complement();
        }
    }
}