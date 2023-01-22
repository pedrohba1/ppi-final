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
        putProduct.setIdUser(product.get().getIdUser());

        putProduct.setProductName(productName);
        putProduct.setProductDescription(productDescription);
        putProduct.setProductPrice(productPrice);
        putProduct.setProductAmount(productAmount);

        return putProduct;
    }
}
