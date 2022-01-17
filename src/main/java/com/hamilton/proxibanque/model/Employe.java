package com.hamilton.proxibanque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Profiles",discriminatorType = DiscriminatorType.STRING)
@Data @NoArgsConstructor @AllArgsConstructor
public abstract class Employe implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Nom;
    private String prenom;
    private String telephone;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String login;
    private String password;
    @OneToMany(mappedBy = "employe",fetch = FetchType.LAZY)
    private Collection<Client> clients;
}