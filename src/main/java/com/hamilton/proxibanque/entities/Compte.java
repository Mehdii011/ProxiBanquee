package com.hamilton.proxibanque.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type_Compte",discriminatorType = DiscriminatorType.STRING)
@Data @NoArgsConstructor
public class Compte implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Id
    private String numeroCompte;
    private double solde;
    private Date dateCreation;
    @ManyToOne
    @JoinColumn(name="Client_Id")
    private Client client;
    @OneToMany(mappedBy = "compte",fetch = FetchType.LAZY)
    private Collection<Operation>  operations;

    public Compte(Long id, String numeroCompte, double solde, Date dateCreation, Client client) {
        this.id = id;
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.dateCreation = dateCreation;
        this.client = client;
    }
}
