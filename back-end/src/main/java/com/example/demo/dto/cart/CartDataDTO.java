package com.example.demo.dto.cart;

import com.example.demo.entity.Cart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CartDataDTO {
    private UUID idCart;
    private UUID idUser;
    private List<UUID> idProduct;

    public CartDataDTO(Cart cart) {
        this.idUser = cart.getIdCart();
        this.idUser = cart.getIdUser();
        this.idProduct = cart.getIdProduct();
    }
}
