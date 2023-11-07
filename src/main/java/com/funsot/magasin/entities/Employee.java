package com.funsot.magasin.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

  /*  @ManyToMany
    private List<Projet> projets;*/

    @ManyToMany
    @JoinTable( name = "affectations",
            joinColumns = @JoinColumn( name = "employee_id" ),
            inverseJoinColumns = @JoinColumn( name = "projet_id" ) )
    private List<Projet> projet;

}
