package com.mapping.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class BillDetailKey implements Serializable {

    @Column(name="PRODUCT_ID")
    Integer productId;
    @Column(name="BILL_ID")
    Integer billId;
}
