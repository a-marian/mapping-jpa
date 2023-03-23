package com.mapping.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class BillDetailKey {

    @Column(name="PRODUCT_ID")
    Integer productId;
    @Column(name="BILL_ID")
    Integer billId;
}
