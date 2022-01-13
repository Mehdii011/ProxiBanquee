package com.hamilton.proxibanque.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Carte Electron")
public class CarteElectron extends Carte{
}
