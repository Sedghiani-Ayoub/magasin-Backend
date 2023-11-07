package com.funsot.magasin.repository;

import com.funsot.magasin.entities.Comment;
import com.funsot.magasin.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    public List<Comment> findByProduct(Product p);
}
