package com.example.demo.service;

import com.example.demo.dto.cart.CartCreationDataDTO;
import com.example.demo.dto.cart.CartDataDTO;
import com.example.demo.dto.cart.CartPutDTO;
import com.example.demo.entity.Cart;
import com.example.demo.entity.User;
import com.example.demo.repository.CartRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    public CartDataDTO createCart(CartCreationDataDTO register) {
        Cart cart = cartRepository.findByUserId(register.getIdUser());
        if(cart != null) {
            throw new HttpClientErrorException(HttpStatus.CONFLICT);
        }

        Cart cartData = new Cart();
        cartData.setUser(new User(register.getIdUser()));
        return new CartDataDTO(cartRepository.save(cartData));
    }

    public CartDataDTO getCartID(UUID idCart) {
        return new CartDataDTO(cartRepository.findById(idCart).orElseThrow(EntityNotFoundException::new));
    }

    public List<CartDataDTO> getAllCart() {
        List<Cart> cartResponse = cartRepository.findAll();
        List<CartDataDTO> listDTO = new ArrayList<>();
        for(Cart cart : cartResponse) {
            CartDataDTO cartDTO = new CartDataDTO(cart);
            listDTO.add(cartDTO);
        }
        return listDTO;
    }

    public CartDataDTO putCart(UUID idCart, CartPutDTO putDTO) {
        Optional<Cart> cart = cartRepository.findById(idCart);
        if(cart.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return new CartDataDTO(cartRepository.save(putDTO.toCart(cart)));
    }

    public void deleteCart(UUID idCart) {
        Optional<Cart> cart = cartRepository.findById(idCart);
        if(cart.isEmpty()) {
            throw new EntityNotFoundException();
        }
        cartRepository.delete(cart.get());
    }
}
