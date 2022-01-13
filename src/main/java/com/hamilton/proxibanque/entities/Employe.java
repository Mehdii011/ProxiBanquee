package com.hamilton.proxibanque.entities;

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

public class Employe implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Nom;
    private String prenom;
    private String telephone;
    private String email;
    private String login;
    private String password;
    @OneToMany(mappedBy = "employe",fetch = FetchType.LAZY)
    private Collection<Client> clients;
}
