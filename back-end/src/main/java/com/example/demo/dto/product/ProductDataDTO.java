package com.example.demo.dto.product;

import com.example.demo.entity.Product;
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
    private UUID idUser;

    public ProductDataDTO(Product product){
        this.idProduct = product.getIdProduct();
        this.productName = product.getProductName();
        this.productDescription = product.getProductDescription();
        this.productPrice = product.getProductPrice();
        this.productAmount = product.getProductAmount();
        this.idUser = product.getIdUser();
    }

}
