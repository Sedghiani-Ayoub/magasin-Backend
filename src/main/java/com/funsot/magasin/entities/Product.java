package com.funsot.magasin.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_name",length = 30,nullable = false,unique = true)
    private String name;
    private double price;
    private int quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "category_product")
    private Category category;
     //@JsonBackReference
    // @OneToMany(mappedBy = "product",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE},orphanRemoval = true)//CascadeType.ALL
   // private List<Comment> comments;

}
