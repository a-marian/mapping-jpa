package com.mapping.model;

import jakarta.persistence.*;
import java.util.Objects;
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

    @Column(name= "status")
    private Boolean status = false;

    @OneToMany(mappedBy = "cashier", cascade = CascadeType.ALL)
    private Set<Bill> bills;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="computer_id", referencedColumnName = "computerId")
    private Computer computer;

    public Integer getCashierId() {
        return cashierId;
    }

    public void setCashierId(Integer cashierId) {
        this.cashierId = cashierId;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Set<Bill> getBills() {
        return bills;
    }

    public void setBills(Set<Bill> bills) {
        this.bills = bills;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("User [name=").append(cashierName).append(", last name=").append(lastName).append("]");
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Cashier cashier = (Cashier) obj;
        return cashierId == cashier.cashierId &&
                Objects.equals(cashierName, ((Cashier) obj).cashierName) &&
                Objects.equals(lastName, ((Cashier) obj).lastName) &&
                Objects.equals(mail,((Cashier) obj).mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cashierId, cashierName, lastName, mail);
    }
}
