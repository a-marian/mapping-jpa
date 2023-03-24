package com.mapping.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long billId;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("customerId")
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("cashierId")
    @JoinColumn(name="CASHIER_ID")
    private Cashier cashier;
    @Column(name="BILL_DATE")
    private Date billDate;
    @Column(name="BILL_TOTAL", precision = 2)
    private Double billTotal;

    @OneToMany(mappedBy="bill")
    private Set<BillDetail> billDetailList;

}
