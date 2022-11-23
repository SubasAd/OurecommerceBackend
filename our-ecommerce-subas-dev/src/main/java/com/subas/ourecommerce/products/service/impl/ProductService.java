package com.subas.ourecommerce.products.service.impl;


import com.subas.ourecommerce.products.entity.Product;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface ProductService {

    ResponseEntity<Product> findById(Long id);
    ResponseEntity<List<Product>> findAll();
    ResponseEntity<Product> deleteById(Long id);
    ResponseEntity<Product> Update(Product product);
    void Create(Product product);
  ResponseEntity<List<Product>> findByTagsName(String tagName);
}
