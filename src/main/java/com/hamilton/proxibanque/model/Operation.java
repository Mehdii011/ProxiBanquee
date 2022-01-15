package com.hamilton.proxibanque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TypeOperation",discriminatorType = DiscriminatorType.STRING)
@Data @AllArgsConstructor @NoArgsConstructor
public abstract class Operation implements Serializable {
@Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idOperation;
    private Date dateOperation;
    private double montant;
    @ManyToOne
    @JoinColumn(name = "Numero_Compte")
    private Compte compte;


}
