package com.example.demo.entity;


import com.example.demo.models.RoleDescription;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleDescription name;

    public Role() {

    }

    public Role(RoleDescription name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RoleDescription getName() {
        return name;
    }

    public void setName(RoleDescription name) {
        this.name = name;
    }
}
