package com.subas.ourecommerce.products.repository;

import com.subas.ourecommerce.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

 List<Product> findByTagsName(String Name );
}
