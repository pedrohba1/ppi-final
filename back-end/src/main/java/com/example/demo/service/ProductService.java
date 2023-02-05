package com.example.demo.service;

import com.example.demo.dto.product.ProductCreationDataDTO;
import com.example.demo.dto.product.ProductDataDTO;
import com.example.demo.dto.product.ProductPutDTO;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product createProduct(ProductCreationDataDTO register) {
        Product product = productRepository.findByName(register.getName());
        if(product != null) {
            throw new HttpClientErrorException(HttpStatus.CONFLICT);
        }

        Product productData = new Product();
        productData.setName(register.getName());
        productData.setPrice(register.getPrice());
        productData.setDescription(register.getDescription());
        productData.setAmount(register.getAmount());
        productData.setPrice(register.getPrice());
        productData.setSeller(new User(register.getUserId()));

        return productRepository.save(productData);
    }

    public Product getProductID(UUID idProduct) {
        return productRepository.findById(idProduct).orElseThrow(EntityNotFoundException::new);
    }

    public List<Product> getAllProduct() {
        List<Product> products = productRepository.findAll();
        List<ProductDataDTO> listDTO = new ArrayList<>();
        return products;
    }

    public Optional<Product> putProduct(UUID idProduct, ProductPutDTO putDTO) {
        Optional<Product> product = productRepository.findById(idProduct);

        if(product.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return product;
    }

    public void deleteProduct(UUID idProduct) {
        Optional<Product> product = productRepository.findById(idProduct);
        if(product.isEmpty()) {
            throw new EntityNotFoundException();
        }
        productRepository.delete(product.get());
    }
}