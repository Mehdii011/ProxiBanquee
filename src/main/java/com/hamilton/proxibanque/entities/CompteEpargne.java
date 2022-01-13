package com.hamilton.proxibanque.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
@Entity
@DiscriminatorValue("Compte Epargne")
@Data @NoArgsConstructor
public class CompteEpargne extends Compte{
    private double taux;

    public CompteEpargne(Long id, String numeroCompte, double solde, Date dateCreation, Client client, double taux) {
        super(id, numeroCompte, solde, dateCreation, client);
        this.taux = taux;
    }
}
