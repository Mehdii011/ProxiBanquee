package com.hamilton.proxibanque.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Carte Visa Premier")

public class CarteVisaPremier extends Carte{

}
