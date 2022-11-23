package com.subas.ourecommerce.products.service.impl;

import com.subas.ourecommerce.products.entity.Product;
import com.subas.ourecommerce.products.repository.ProductRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {


    final
    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public ResponseEntity<Product> findById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product product = null;
        if (optionalProduct.isPresent()) product = optionalProduct.get();
        return ResponseEntity.ok(product);
    }

    @Override
    public ResponseEntity<List<Product>> findAll() {
        List<Product> listofProducts = productRepository.findAll();
        return ResponseEntity.ok(listofProducts);


    }

    @Override
    public ResponseEntity<Product> deleteById(Long id) {
        Optional<Product> pr = productRepository.findById(id);
        if (pr.isPresent()) {
            productRepository.deleteById(id);
            return ResponseEntity.ok(pr.get());

        }

        return ResponseEntity.ok(pr.get());


    }

    @Override
    public ResponseEntity<Product> Update(Product product) {

        Optional<Product> pr = productRepository.findById(product.getId());
        if (pr.isPresent()) {
            pr.get().setDeleted(product.isDeleted());
            pr.get().setId(product.getId());
            pr.get().setName(product.getName());
            pr.get().setPrice(product.getPrice());
            productRepository.save(pr.get());
            return ResponseEntity.ok(pr.get());
        } else {
            return ResponseEntity.ok(product);
        }


    }

    @Override
    public void Create(Product product) {


        productRepository.save(product);
        ResponseEntity.ok(product);


    }



    @Override
    public ResponseEntity<List<Product>> findByTagsName(String  tag){
      List<Product> products =   productRepository.findByTagsName(tag);

       return ResponseEntity.ok(products);
    }
}
