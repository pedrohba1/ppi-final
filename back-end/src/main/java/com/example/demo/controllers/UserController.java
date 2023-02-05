package com.example.demo.controllers;

import com.example.demo.dto.auth.SignupDTO;
import com.example.demo.dto.user.UserCreationDataDTO;
import com.example.demo.dto.user.UserDataDTO;
import com.example.demo.dto.user.UserPutDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;
    @Autowired
    private UserRepository userRepository;



    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Object> find() {
        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.findAll());
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_USER")
    public UserDataDTO createUser(
            @RequestBody SignupDTO registerDTO
    ) {
        return userService.createUser(registerDTO);
    }

    @GetMapping("/id/{userId}")
    public UserDataDTO searchUserById(@PathVariable UUID userId) {
        return userService.getUserID(userId);
    }

    @GetMapping("/id")
    public List<UserDataDTO> searchAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/alterUser/{userId}")
    public UserDataDTO putUser(@PathVariable UUID userId, @RequestBody UserPutDTO putDTO) {
        return userService.putUser(userId, putDTO);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public void deleteUser(@PathVariable UUID userId) {
        userService.deleteUser(userId);
    }


}
