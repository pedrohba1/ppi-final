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
    private UUID idProduct;
    private String productName;
    private String productDescription;
    private Double productPrice;
    private Integer productAmount;
    private User user;

    public ProductDataDTO(Product product){
        this.idProduct = product.getIdProduct();
        this.productName = product.getName();
        this.productDescription = product.getDescription();
        this.productPrice = product.getPrice();
        this.productAmount = product.getAmount();
        this.user = product.getUser();
    }

}
