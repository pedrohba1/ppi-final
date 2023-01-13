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
    @Column(name = "id_product")
    private UUID id_product;

    @Column(nullable = false, name = "priductName")
    private String productName;

    @Column(nullable = false, name = "productDescription")
    private String productDescription;

    @Column(nullable = false, name = "productPrice")
    private Double productPrice;

    @Column(nullable = false, name = "productAmount")
    private Integer productAmount;

    @ManyToOne()
    @JoinColumn(
            name = "id_user",
            referencedColumnName = "id_user",
            insertable = false,
            updatable = false
    )
    private User user;

}
