package com.example.demo.service;

import com.example.demo.dto.cart.CartCreationDataDTO;
import com.example.demo.dto.cart.CartDataDTO;
import com.example.demo.dto.cart.CartPutDTO;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.repository.CartRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;


    public Cart getUserCart(UUID userId) {
        Cart cart = cartRepository.findByUserId(userId);
        return cart;
    }


    public Cart addToCart(UUID userId, Set<Product> products) {
        Cart cart = cartRepository.findByUserId(userId);
        if(cart == null){
            cart = new Cart();
            cart.setProducts(products);
            cart.setUser(new User(userId));
            return cartRepository.save(cart);
        }

        cart.setUser(new User(userId));
        cart.getProducts().addAll(products);


        return cartRepository.save(cart);
    }

    public void removeFromCart(UUID userId, Set<Product> products) {

        Cart cart = cartRepository.findByUserId(userId);
        if (cart == null) {
            throw new IllegalArgumentException("No cart found for user: " + userId);
        }
        cart.getProducts().removeAll(products);
        cartRepository.save(cart);


    }

}
