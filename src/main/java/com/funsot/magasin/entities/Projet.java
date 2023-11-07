package com.funsot.magasin.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "projets")
@Data
public class Projet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

   /* @ManyToMany
    private List<Employee> employees;*/

    @ManyToMany
    @JoinTable( name = "affectations",
            joinColumns = @JoinColumn( name = "projet_id" ),
            inverseJoinColumns = @JoinColumn( name = "employee_id" ) )
    private List<Employee> employees;

}
