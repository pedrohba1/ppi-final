package com.example.demo.repository;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID> {

    Cart findByUserId(@Param("user_id") UUID userId);
}
