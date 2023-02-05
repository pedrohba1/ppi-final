package com.example.demo.dto.product;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductCreationDataDTO {
    private String productName;
    private String productDescription;
    private Double productPrice;
    private Integer productAmount;
    private UUID userId;
}
