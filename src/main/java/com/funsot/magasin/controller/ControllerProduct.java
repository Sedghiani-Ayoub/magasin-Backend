package com.funsot.magasin.controller;

import com.funsot.magasin.entities.Category;
import com.funsot.magasin.entities.Product;
import com.funsot.magasin.exeptions.ResourceNotFound;
import com.funsot.magasin.repository.ProductRepository;
import com.funsot.magasin.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/products")
public class ControllerProduct {

  @Autowired
  ProductService productService;

  @PostMapping
  public Product addProduct(@RequestBody Product product) {
      return productService.addProduct(product);
  }
@GetMapping
public List<Product> getProducts() {

  return productService.getAllProduct();
}
@GetMapping("/{id}")
public  Product getProduct(@PathVariable("id") long idp) throws ResourceNotFound {
    return productService.getProduct(idp);
}
  @DeleteMapping ("/{id}")
  public  Map<String, Boolean> deleteProduct(@PathVariable("id") long idp) throws ResourceNotFound {

   productService.deleteProduct(idp);
   Map<String, Boolean> resp = new HashMap<>();
   resp.put("deleted", Boolean.TRUE);
  return resp;
  }
  @PutMapping("/{id}")
  public Product updateProduct(@PathVariable("id") long idp,@RequestBody Product product) throws ResourceNotFound {
    {

  return  productService.updateProduct(idp,product);

    }

  }
  @GetMapping("/categry/search")
    public List<Product> searchCategory(@ModelAttribute Category category){
      return  productService.getByCategory(category);

  }
  @GetMapping("/advancedSearch")
    public  List<Product> advancedSearch(@ModelAttribute Category category, String namePrefix){
      return  productService.advancedSearch(category,namePrefix);

  }
}
