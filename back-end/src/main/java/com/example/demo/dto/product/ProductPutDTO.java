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
    private String name;
    private String description;
    private Double price;
    private Integer amount;

    private String image;

    public Product toProduct(Optional<Product> product) {
        Product putProduct = new Product();
        putProduct.setIdProduct(product.get().getIdProduct());
        putProduct.setSeller(product.get().getSeller());

        putProduct.setName(name);
        putProduct.setDescription(description);
        putProduct.setPrice(price);
        putProduct.setAmount(amount);

        return putProduct;
    }
}
