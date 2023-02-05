package com.example.demo.dto.product;

import com.example.demo.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductPutDTO {
    private String productName;
    private String productDescription;
    private Double productPrice;
    private Integer productAmount;

    public Product toProduct(Optional<Product> product) {
        Product putProduct = new Product();
        putProduct.setIdProduct(product.get().getIdProduct());
        putProduct.setUser(product.get().getUser());

        putProduct.setName(productName);
        putProduct.setDescription(productDescription);
        putProduct.setPrice(productPrice);
        putProduct.setAmount(productAmount);

        return putProduct;
    }
}
