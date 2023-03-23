package com.mapping.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    @Column(name ="CUSTOMER_NAME", length = 50, nullable = false)
    private String customerName;
    @Column(name = "CUSTOMER_ADDRESS", length = 50)
    private String customerAddress;
    @Column(name = "TAX_IDENTIFIER", length = 25)
    private String taxIdentifier;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Bill> orderList = new ArrayList<>();


}
