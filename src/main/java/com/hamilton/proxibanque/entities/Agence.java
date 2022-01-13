package com.hamilton.proxibanque.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Agence implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private Date dateOverture;
    @OneToOne
    private Gerant gerant;
}
