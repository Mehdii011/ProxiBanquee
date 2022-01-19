package com.hamilton.proxibanque.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type_Compte",discriminatorType = DiscriminatorType.STRING)
@Data @NoArgsConstructor
public abstract class Compte implements Serializable {

    @Id
    private Long numeroCompte;
    private double solde;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCreation;
    @ManyToOne
    @JoinColumn(name="Client_Id")
    @JsonBackReference
    private Client client;
    @OneToMany(mappedBy = "compte",fetch = FetchType.LAZY)
    @JsonManagedReference
    private Collection<Operation>  operations;

    public Compte( Long numeroCompte, double solde, Date dateCreation, Client client) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.dateCreation = dateCreation;
        this.client = client;
    }
}
