package com.example.demo.entity;

import com.example.demo.models.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
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

    @Column(nullable = false, name = "username")
    private String username;

    @Column(nullable = false, name = "password")
    private String password;


    @Column(nullable = false, name = "roles")
    private Set<Role> roles = new HashSet<>();


    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public User(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }
}
