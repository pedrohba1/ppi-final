package com.example.demo.repository;

import com.example.demo.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID> {
    @Query(
            value = "SELECT distinct cart FROM Cart cart" +
                    "WHERE product.idUser= : idUser"
    )
    Cart findCartByIdUser(@Param("idUser") UUID idUser);
}
