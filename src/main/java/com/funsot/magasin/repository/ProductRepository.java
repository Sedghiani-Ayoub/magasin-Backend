package com.funsot.magasin.repository;

import com.funsot.magasin.entities.Category;
import com.funsot.magasin.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

    //select p from Product p where p.category := category  JPQL --> SQL
    public List<Product> findByCategory(Category category);

    public List<Product> findByCategoryAndName(Category category, String name);

    @Query(value = "SELECT p FROM Product p WHERE p.category = :category AND UPPER(p.name)  LIKE %:name%")
    public List<Product> search(@Param("category") Category category, @Param("name") String name);

}
