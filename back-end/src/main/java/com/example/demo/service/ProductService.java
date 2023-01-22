package com.example.demo.service;

import com.example.demo.dto.product.ProductCreationDataDTO;
import com.example.demo.dto.product.ProductDataDTO;
import com.example.demo.dto.product.ProductPutDTO;
import com.example.demo.dto.user.UserDataDTO;
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

    public ProductDataDTO createProduct(ProductCreationDataDTO register) {
        Product product = productRepository.findByProductName(register.getProductName());
        if(product != null) {
            throw new HttpClientErrorException(HttpStatus.CONFLICT);
        }

        Product productData = new Product();
        productData.setProductName(register.getProductName());
        productData.setProductPrice(register.getProductPrice());
        productData.setProductDescription(register.getProductDescription());
        productData.setProductAmount(register.getProductAmount());
        productData.setProductPrice(register.getProductPrice());
        productData.setIdUser(register.getIdUser());

        return new ProductDataDTO(productRepository.save(productData));
    }

    public ProductDataDTO getProductID(UUID idProduct) {
        return new ProductDataDTO(productRepository.findById(idProduct).orElseThrow(EntityNotFoundException::new));
    }

    public List<ProductDataDTO> getAllProduct() {
        List<Product> productResponse = productRepository.findAll();
        List<ProductDataDTO> listDTO = new ArrayList<>();
        for(Product product : productResponse) {
            ProductDataDTO productDTO = new ProductDataDTO(product);
            listDTO.add(productDTO);
        }
        return listDTO;
    }

    public ProductDataDTO putProduct(UUID idProduct, ProductPutDTO putDTO) {
        Optional<Product> product = productRepository.findById(idProduct);

        if(product.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return new ProductDataDTO(productRepository.save(putDTO.toProduct(product)));
    }

    public void deleteProduct(UUID idProduct) {
        Optional<Product> product = productRepository.findById(idProduct);
        if(product.isEmpty()) {
            throw new EntityNotFoundException();
        }
        productRepository.delete(product.get());
    }
}
