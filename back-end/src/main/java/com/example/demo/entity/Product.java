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
@Table(name = "TB_PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idProduct")
    private UUID idProduct;

    @Column(nullable = false, name = "productName")
    private String productName;

    @Column(nullable = false, name = "productDescription")
    private String productDescription;

    @Column(nullable = false, name = "productPrice")
    private Double productPrice;

    @Column(nullable = false, name = "productAmount")
    private Integer productAmount;

    @Column(nullable = false, name = "idUser")
    private UUID idUser;

    @ManyToOne()
    @JoinColumn(
            name = "idUser",
            referencedColumnName = "idUser",
            insertable = false,
            updatable = false
    )
    private User user;

}
