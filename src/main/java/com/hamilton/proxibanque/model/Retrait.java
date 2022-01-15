package com.hamilton.proxibanque.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.Optional;

@Entity
@DiscriminatorValue("Retrait")
public class Retrait extends Operation{

    public Retrait(Long idOperation, Date dateOperation, double montant, Compte compte) {
        super(idOperation, dateOperation, montant, compte);
    }


    public Retrait() {

    }
}
