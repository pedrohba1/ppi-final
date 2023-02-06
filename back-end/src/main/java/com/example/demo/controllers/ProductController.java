package com.example.demo.controllers;


import com.example.demo.dto.auth.JwtDTO;
import com.example.demo.dto.auth.MessageResponseDTO;
import com.example.demo.dto.product.ProductCreationDataDTO;
import com.example.demo.dto.product.ProductDataDTO;
import com.example.demo.dto.product.ProductPutDTO;
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

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/products")
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
        productCreationDataDto.setImage(productData.getImage());

        Product product = this.productService.createProduct(productCreationDataDto);

        return ResponseEntity.ok(product);
    }


    @GetMapping("/list")
    public ResponseEntity<List<Product>> searchAllProducts() {
        List<Product> products = this.productService.getAllProduct();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{productId}")
    public Product searchProductById(@PathVariable UUID productId) {
        return productService.getProductID(productId);
    }



    @PutMapping("/edit/{productId}")
    public Optional<Product> putProduct(@PathVariable UUID productId,
                                        @AuthenticationPrincipal UserDetailsImpl userDetails,
                                        @RequestBody ProductPutDTO putDTO) {
        return this.productService.putProduct(productId, userDetails.getId() , putDTO);
    }

    @DeleteMapping("/delete/{productId}")
    public  ResponseEntity<?> deleteProduct(@PathVariable UUID productId) {
         this.productService.deleteProduct(productId);

        return ResponseEntity.ok(new MessageResponseDTO("Product deleted"));

    }


}