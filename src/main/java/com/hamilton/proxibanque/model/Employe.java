package com.hamilton.proxibanque.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Profiles",discriminatorType = DiscriminatorType.STRING)
@Data @NoArgsConstructor @AllArgsConstructor
public abstract class Employe implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Ce champ ne doit pas être null !")
    @Size(min = 3,message = "Ce champ doit avoir au moins 3 caractères !")
    private String Nom;
    @NotBlank(message = "Ce champ ne doit pas être null")
    @Size(min = 3,message = "Ce champ doit avoir au moins 3 caractères !")
    private String prenom;
    @NotBlank(message = "Ce champ ne doit pas être null !")
    private String telephone;
    @Column(unique = true)
    @Email(message = "Ce champ doit respecter le format email exemple@exemple.com")
    private String email;
    @Column(unique = true)
    private String login;
    @NotBlank(message = "Ce champ ne doit pas être null")
    @Size(min=8,message = "mot de passe doit avoir au moins 8 caractères ! ")
    @Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$\n",message ="Ce mot de passe doit contenir au minimum 8 caractères, à savoir : au moins une lettre minuscule et une lettre majuscule, un caractère spécial et un chiffre")
    private String password;
    @OneToMany(mappedBy = "employe",fetch = FetchType.LAZY)
    @JsonManagedReference
    private Collection<Client> clients;
}
