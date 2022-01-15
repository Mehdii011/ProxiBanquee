package com.hamilton.proxibanque.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Carte Electron")
public class CarteElectron extends Carte{
}
