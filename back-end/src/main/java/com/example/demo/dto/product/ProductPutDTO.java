package com.example.demo.dto.product;

import com.example.demo.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductPutDTO {
    private String productName;
    private String productDescription;
    private Double productPrice;
    private Integer productAmount;

    public Product toProduct(Product product) {
        Product putProduct = new Product();
        putProduct.setIdProduct(product.getIdProduct());
        putProduct.setIdUser(product.getIdUser());

        putProduct.setProductName(productName);
        putProduct.setProductDescription(productDescription);
        putProduct.setProductPrice(productPrice);
        putProduct.setProductAmount(productAmount);

        return putProduct;
    }
}
