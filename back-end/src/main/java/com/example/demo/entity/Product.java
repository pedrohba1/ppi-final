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
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false )
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer amount;


    @Column(nullable = false)
    private String image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private User seller;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = true)
    private User buyer;
}
