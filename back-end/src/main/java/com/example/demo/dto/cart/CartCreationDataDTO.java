package com.example.demo.dto.cart;

import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CartCreationDataDTO {
    private UUID idUser;
    private List<UUID> idProduct;
}
