package com.mapping.model;

import jakarta.persistence.*;

@Entity
@Table(name="computer")
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer computerId;
    @Column(name="CODE", nullable = false, length = 25)
    private String code;
    @Column(name="BRAND")
    private String brand;
    @OneToOne(mappedBy = "computer")
    private Cashier cashier;

    public Integer getComputerId() {
        return computerId;
    }

    public void setComputerId(Integer computerId) {
        this.computerId = computerId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }
}
