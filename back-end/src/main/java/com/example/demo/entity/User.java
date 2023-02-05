package com.example.demo.entity;

import com.example.demo.models.RoleDescription;
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
    @Column()
    private UUID id;

    @Column(nullable = false, name = "username")
    private String username;

    @Column(nullable = false, name = "password")
    private String password;




    @ManyToMany(fetch = FetchType.LAZY)
    @Column(nullable = false, name = "roles")
    @JoinTable(name="roles",
        joinColumns = @JoinColumn(name ="user_id")

    )
    private Set<RoleDescription> roles = new HashSet<>();


    public void setRoles(Set<RoleDescription> roles) {
        this.roles = roles;
    }


    public User(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }
}
