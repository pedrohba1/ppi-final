package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUser")
    private UUID idUser;

    @Column(nullable = false, name = "userName")
    private String userName;

    @Column(nullable = false, name = "password")
    private String password;
}
