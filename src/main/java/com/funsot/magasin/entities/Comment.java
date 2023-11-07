package com.funsot.magasin.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Data
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String text;
    private LocalDateTime creationTime;
    private Long rating;

    @ManyToOne

    @JoinColumn(name = "product_id",referencedColumnName = "id")
    @JsonManagedReference
    private Product product;

}
