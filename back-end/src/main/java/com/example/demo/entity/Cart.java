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
    @Column(name = "idCart")
    private UUID idCart;

    @Column(nullable = false, name = "idUser")
    private UUID idUser;

    @OneToOne()
    @JoinColumn(
            name = "idUser",
            referencedColumnName = "idUser",
            insertable = false,
            updatable = false
    )
    private User user;

    @Column(nullable = false, name = "idUser")
    private List<UUID> idProduct;

    @OneToMany()
    @JoinColumn(
            name = "idProduct",
            referencedColumnName = "idProduct",
            insertable = false,
            updatable = false
    )
    private List<Product> products;
}
