package com.funsot.magasin.services;
import com.funsot.magasin.entities.Category;
import com.funsot.magasin.entities.Product;
import com.funsot.magasin.exeptions.ResourceNotFound;

import java.util.List;

public interface ProductService  {

    public Product addProduct(Product p);
    public  Product updateProduct(long id,Product P) throws ResourceNotFound;
    public Product getProduct(long idProduct) throws ResourceNotFound;
    public List<Product> getAllProduct();
    public void deleteProduct(Long idProduct) throws ResourceNotFound;
    public List<Product> getByCategory (Category category);
    public List<Product> search (Category category,String name);
    public List<Product> advancedSearch(Category category , String namePrefix);

}
