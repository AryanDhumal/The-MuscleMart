package com.musclemart.musclemart.controller;

import com.musclemart.musclemart.entity.Product;
import com.musclemart.musclemart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*") // allows frontend to access from browser
public class ProductController {

    @Autowired
    private ProductService productService;

    // GET all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // POST new product
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
}
