package com.example.demo.dto.cart;

import com.example.demo.entity.Cart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CartPutDTO {
    private List<UUID> idProducts;

    public Cart toCart(Optional<Cart> cart) {
        Cart putCart = new Cart();
        putCart.setId(cart.get().getId());
        putCart.setUser(cart.get().getUser());


        return putCart;
    }
}
