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
@Table(name = "TB_CART")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cart")
    private UUID id_cart;

    @OneToOne()
    @JoinColumn(
            name = "id_user",
            referencedColumnName = "id_user",
            insertable = false,
            updatable = false
    )
    private User user;

    @OneToMany()
    @JoinColumn(
            name = "id_product",
            referencedColumnName = "id_product",
            insertable = false,
            updatable = false
    )
    private List<Product> products;
}
