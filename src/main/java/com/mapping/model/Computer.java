package com.mapping.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="computer")
@Data
@NoArgsConstructor
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
}
