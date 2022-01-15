package com.hamilton.proxibanque.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Conseiller")
public class Conseiller extends Employe{
}
