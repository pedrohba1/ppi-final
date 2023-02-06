package com.example.demo.dto.product;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductDataDTO {

    private String name;
    private String description;
    private Double price;
    private Integer amount;
    private User user;

    private String image;


}
