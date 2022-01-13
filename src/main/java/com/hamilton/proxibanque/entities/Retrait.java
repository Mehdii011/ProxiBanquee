package com.hamilton.proxibanque.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Retrait")
public class Retrait extends Operation{


}
