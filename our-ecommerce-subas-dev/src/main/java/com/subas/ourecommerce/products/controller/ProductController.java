package com.subas.ourecommerce.products.controller;

import com.subas.ourecommerce.products.entity.Product;
import com.subas.ourecommerce.products.entity.Tag;
import com.subas.ourecommerce.products.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController

@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService productService;



    @CrossOrigin
    @GetMapping("/products/{productId}")
    ResponseEntity<Product> findProduct(@PathVariable Long productId) {
        return this.productService.findById(productId);
    }

    @CrossOrigin
    @GetMapping("/products")
    ResponseEntity<List<Product>> findAllProducts() {
        final ResponseEntity<List<Product>> all = this.productService.findAll();
        return all;
    }
@CrossOrigin
    @PostMapping("/admin/products")
    ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        productService.Create(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/admin/products/{productId}")
    ResponseEntity<Product> deleteProduct(@PathVariable Long productId) {
        return this.productService.deleteById(productId);
    }
    @CrossOrigin
    @RequestMapping(value = {"/products/search/", "products/search"}, method = RequestMethod.GET)
    public ResponseEntity<List<Product>> search(
            @RequestParam Map<String,String> RequestParams, ModelMap model) {
       return productService.findByTagsName(RequestParams.get("tagName"));

    }

}

