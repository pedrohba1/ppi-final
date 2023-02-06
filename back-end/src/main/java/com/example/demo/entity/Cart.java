package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column()
    private UUID id;


    @OneToOne()
    @JoinColumn()
    private User user;

    @OneToMany()
    @JoinColumn()
    private List<Product> products;
}
