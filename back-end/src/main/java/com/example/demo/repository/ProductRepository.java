package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query(
            value = "SELECT distinct product FROM Product product" +
                    "WHERE product.productName = : productName"
    )
    Product findProductByName(@Param("productName") String productName);
}
