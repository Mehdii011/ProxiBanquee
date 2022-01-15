package com.hamilton.proxibanque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Client implements Serializable {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private int codePostal;
    private String Ville;
    private String telephone;
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Collection<Compte> comptes;
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Collection<Carte> cartes;
    @ManyToOne
    @JoinColumn(name="Conseiller_Id")
    private Employe employe;

    public Client(Long id, String nom, String prenom, String adresse, int codePostal, String ville, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        Ville = ville;
        this.telephone = telephone;
    }
}
