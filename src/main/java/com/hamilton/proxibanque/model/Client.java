package com.hamilton.proxibanque.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  //  @NotBlank(message = "Ce champ ne doit pas être null !")
  //  @Size(min = 3,message = "Ce champ doit avoir au moins 3 caractères !")
    private String nom;
  //  @NotBlank(message = "Ce champ ne doit pas être null !")
  //  @Size(min = 3,message = "Ce champ doit avoir au moins 3 caractères !")
    private String prenom;
    private String adresse;
    private int codePostal;
   // @NotBlank(message = "Ce champ ne doit pas être null !")
    private String Ville;
  //  @NotBlank(message = "Ce champ ne doit pas être null !")
    private String telephone;
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Collection<Compte> comptes;
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Carte> cartes;
    @ManyToOne
    @JoinColumn(name = "Conseiller_Id")
    @JsonBackReference
    private Employe employe;

    public Client(Long id, String nom, String prenom, String adresse, int codePostal, String ville, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.Ville = ville;
        this.telephone = telephone;
    }
}
