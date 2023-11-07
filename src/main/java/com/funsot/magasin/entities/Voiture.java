package com.funsot.magasin.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("V")
public class Voiture extends Vehicule{

    private String puissance;

}
