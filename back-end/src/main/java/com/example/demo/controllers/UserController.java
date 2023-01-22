package com.example.demo.controllers;

import com.example.demo.dto.user.UserDataDTO;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private ProductService productService;
//    @Autowired
//    private UserRepository userRepository;
//
//
//    @PostMapping("/create")
//    public ResponseEntity<Object> createUser(@RequestBody UserDataDTO userData) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userData));
//    }
//
//
//    @GetMapping("")
//    public ResponseEntity<Object> find() {
//        return ResponseEntity.status(HttpStatus.CREATED).body(userService.findAll());
//    }

}
