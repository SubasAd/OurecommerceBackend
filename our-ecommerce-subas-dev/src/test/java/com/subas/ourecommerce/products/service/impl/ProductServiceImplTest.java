package com.subas.ourecommerce.products.service.impl;

import com.subas.ourecommerce.OurEcommerceApplication;
import com.subas.ourecommerce.products.entity.Product;
import com.subas.ourecommerce.products.entity.Tag;
import com.subas.ourecommerce.products.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes =OurEcommerceApplication.class)
@Transactional

class ProductServiceImplTest {

    @Autowired  ProductRepository productRepository;
    @Test
    public void testdb()
    {
        Product pr = new Product();
        pr.setName("T shirt");

        Tag t =new Tag();
        t.setName("T-shirt");
       ;



    }

}