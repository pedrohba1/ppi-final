package com.example.demo.controllers;


import com.example.demo.dto.product.ProductDataDTO;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> createProduct(
            @RequestBody ProductDataDTO productData,
            @Authentication authentication
    ) {
        UUID id = UUID.fromString((String) authentication.getPrincipal());
        Optional<User> optionalUser = userService.findById(id);
        if(optionalUser.isEmpty()){
            throw new UserException("user does not exist");
        }
        product.setCreator(optionalUser.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }



    @GetMapping()
    public ResponseEntity<Object> findProducts(
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.findALl());
    }



}