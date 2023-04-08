package com.mapping.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @Column(name ="CUSTOMER_NAME", length = 50, nullable = false)
    private String customerName;
    @Column(name = "ADDRESS", length = 50)
    private String address;
    @Column(name = "IDENTIFIER", length = 25, unique = true)
    private String identifier;
    @Column(name ="MAIL", unique = true, nullable = false)
    private String mail;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Bill> orderList = new ArrayList<>();

}
