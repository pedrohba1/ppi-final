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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column()
    private UUID idProduct;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false )
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer amount;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private User seller;

}
