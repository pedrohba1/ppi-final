package com.example.demo.entity;

import com.example.demo.models.RoleEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "app_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column()
    private UUID id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;


    public User(UUID userId) {
        this.id = userId;
    }


    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public User(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    @ManyToMany()
    private Set<Role> roles;

}
