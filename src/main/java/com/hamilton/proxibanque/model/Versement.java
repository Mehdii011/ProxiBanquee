package com.hamilton.proxibanque.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.Optional;

@Entity
@DiscriminatorValue("Versement")
public class Versement extends Operation{
    public Versement(Long idOperation, Date dateOperation, double montant, Compte compte) {
        super(idOperation, dateOperation, montant, compte);
    }

    public Versement() {

    }
}
