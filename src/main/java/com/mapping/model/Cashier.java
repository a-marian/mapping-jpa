package com.mapping.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="CASHIER")
public class Cashier {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer cashierId;
    @Column(name="CASHIER_NAME", nullable = false, length = 50)
    private String cashierName;
    @Column(name="LAST_NAME", nullable = false)
    private String lastName;
    @Column(name="MAIL")
    private String mail;
    @OneToMany(mappedBy = "cashier", cascade = CascadeType.ALL)
    private Set<Bill> bills;
}
