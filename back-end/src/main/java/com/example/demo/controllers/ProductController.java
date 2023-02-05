package com.example.demo.controllers;


import com.example.demo.dto.auth.JwtDTO;
import com.example.demo.dto.auth.MessageResponseDTO;
import com.example.demo.dto.product.ProductCreationDataDTO;
import com.example.demo.dto.product.ProductDataDTO;
import com.example.demo.entity.Product;
import com.example.demo.security.services.UserDetailsImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Object> createProduct(
            @RequestBody ProductDataDTO productData,
            @AuthenticationPrincipal UserDetailsImpl userDetails
            ) {

        ProductCreationDataDTO productCreationDataDto = new ProductCreationDataDTO();
        productCreationDataDto.setName(productData.getName());
        productCreationDataDto.setDescription(productData.getDescription());
        productCreationDataDto.setAmount(productData.getAmount());
        productCreationDataDto.setPrice(productData.getPrice());
        productCreationDataDto.setUserId(userDetails.getId());

        Product product = this.productService.createProduct(productCreationDataDto);

        return ResponseEntity.ok(product);
    }



    @GetMapping()
    public ResponseEntity<Object> findProducts(
    ) {
        return (ResponseEntity<Object>) ResponseEntity.ok();
    }



}