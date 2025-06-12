package com.musclemart.musclemart.repository;

import com.musclemart.musclemart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Spring Boot will auto-generate all the basic CRUD methods
}
