package com.funsot.magasin.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("M")
public class Moto extends Vehicule{

    private String couleur;
}
