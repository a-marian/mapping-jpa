package com.mapping.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name ="CASHIER")
public class Cashier {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer cashierId;
    @Column(name="CASHIER_NAME", nullable = false, length = 50)
    private String cashierName;
    @Column(name="LAST_NAME", nullable = false)
    private String lastName;
    @Column(name="MAIL")
    private String mail;
    @OneToMany(mappedBy = "cashier", cascade = CascadeType.ALL)
    private Set<Bill> bills;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="computer_id", referencedColumnName = "computerId")
    private Computer computer;
}
