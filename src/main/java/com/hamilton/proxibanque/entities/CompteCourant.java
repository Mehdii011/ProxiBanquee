package com.hamilton.proxibanque.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
@Entity
@DiscriminatorValue("Compte Courant")
@Data @NoArgsConstructor
public class CompteCourant extends Compte{

    private double decouvert;

    public CompteCourant(Long id, String numeroCompte, double solde, Date dateCreation, Client client, double decouvert) {
        super(id, numeroCompte, solde, dateCreation, client);
        this.decouvert = decouvert;
    }
}
