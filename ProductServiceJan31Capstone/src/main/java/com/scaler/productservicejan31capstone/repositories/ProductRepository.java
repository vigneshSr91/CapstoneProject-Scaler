package com.scaler.productservicejan31capstone.repositories;

import com.scaler.productservicejan31capstone.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);
}
