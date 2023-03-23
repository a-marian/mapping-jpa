package com.mapping.model;

import jakarta.persistence.*;

@Entity
public class BillDetail {

    @EmbeddedId
    private BillDetailKey billDetailId;
    @ManyToOne
    @MapsId("billId")
    @JoinColumn(name = "BILL_ID", referencedColumnName = "billId")
    private Bill bill;
    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name="quantity")
    private Integer quantity;

}
