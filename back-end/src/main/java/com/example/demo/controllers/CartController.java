package com.example.demo.controllers;

import com.example.demo.dto.auth.MessageResponseDTO;
import com.example.demo.dto.cart.AddToCartDTO;
import com.example.demo.dto.cart.RemoveFromCartDTO;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.security.services.UserDetailsImpl;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/my")
    public ResponseEntity<Cart> getUserCart(
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        Cart cart = this.cartService.getUserCart(userDetails.getId());
        return ResponseEntity.ok(cart);
    }


    @PostMapping("/add")
    public Cart addToCart(@RequestBody AddToCartDTO addToCartDTO,
                          @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {


        Set<Product> products = new HashSet<>();
        for (UUID productId : addToCartDTO.getProductIds()) {
            Product product = new Product(productId);
            products.add(product);
        }


        return this.cartService.addToCart(userDetails.getId(), products);
    }

    @DeleteMapping("/remove/")
    public ResponseEntity<?> removeFromCart(
            @RequestBody RemoveFromCartDTO removeFromCartDTO,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {

        Set<Product> products = new HashSet<>();
        for (UUID productId : removeFromCartDTO.getProductIds()) {
            Product product = new Product(productId);
            products.add(product);
        }

        this.cartService.removeFromCart(userDetails.getId(), products);

        return ResponseEntity.ok(new MessageResponseDTO("product removed from cart"));


    }
}