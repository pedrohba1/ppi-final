package com.example.demo.controllers;

import com.example.demo.dto.auth.JwtDTO;
import com.example.demo.dto.auth.MessageResponseDTO;
import com.example.demo.dto.auth.SigninDTO;
import com.example.demo.dto.auth.SignupDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;



    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser( @RequestBody SigninDTO siginDTO) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(siginDTO.getUserName(), siginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtDTO(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser( @RequestBody SignupDTO signupDTO) {
        if (userRepository.existsByUserName(signupDTO.getUserName())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        // Create new user's account
        User user = new User(signupDTO.getUserName(),
                encoder.encode(signupDTO.getPassword()));



        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponseDTO("User registered successfully!"));
    }
}