package com.example.demo.dto.product;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductCreationDataDTO {
    private String name;
    private String description;
    private  String image;
    private Double price;
    private Integer amount;
    private UUID userId;
}
