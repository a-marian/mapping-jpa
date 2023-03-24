package com.mapping.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(name="PRODUCT_CODE", length = 20)
    private String productCode;
    @Column(name="PRODUCT_NAME", length = 100)
    private String productName;
    @Column(name="DESCRIPTION", length = 250)
    private String description;
    @Column(name="PRICE", precision = 2)
    private Double price;

    @OneToMany(mappedBy = "product")
    private Set<BillDetail> billDetails;

}
