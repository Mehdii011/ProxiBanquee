package com.hamilton.proxibanque.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Carte Visa Premier")

public class CarteVisaPremier extends Carte{

}
