package com.hamilton.proxibanque.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("Gerant")
@NoArgsConstructor @AllArgsConstructor
public class Gerant extends Employe{
    @OneToOne
    private Agence agence;
}
