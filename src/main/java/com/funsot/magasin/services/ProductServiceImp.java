package com.funsot.magasin.services;

import com.funsot.magasin.entities.Category;
import com.funsot.magasin.entities.Product;
import com.funsot.magasin.exeptions.ResourceNotFound;
import com.funsot.magasin.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImp implements ProductService {
@Autowired
ProductRepository productRepository;
    @Override
    public Product addProduct(Product p) {

        return productRepository.save(p);
    }


    @Override
    public Product updateProduct(long idp, Product p) throws ResourceNotFound {

        Product product1 = productRepository.findById(idp).orElseThrow(
                ()-> new ResourceNotFound("Product not found for id : "+idp)
        );

        product1.setName(p.getName());
        product1.setPrice(p.getPrice());
        product1.setCategory(p.getCategory());
        product1.setQuantity(p.getQuantity());
        return productRepository.save(p);
    }
    @Override
    public Product getProduct(long idProduct) throws ResourceNotFound {
        Product p = productRepository.findById(idProduct).orElseThrow(
                ()-> new ResourceNotFound("product not found for id :"+idProduct)
        );
        return p ;
        //return productRepository.findById(idProduct).get();
    }

    @Override
    public List<Product> getAllProduct() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public void deleteProduct(Long idProduct) throws ResourceNotFound {
        Product p = productRepository.findById(idProduct).orElseThrow(
                ()-> new ResourceNotFound("Product not found for id : "+idProduct));
        productRepository.deleteById(idProduct);
    }

    @Override
    public List<Product> getByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> search(Category category , String name) {
        return productRepository.findByCategoryAndName(category,name);
    }

    @Override
    public List<Product> advancedSearch(Category category, String namePrefix) {
        return productRepository.search(category,namePrefix);
    }

}
