package com.hamilton.proxibanque.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Versement")

public class Versement extends Operation{
}
