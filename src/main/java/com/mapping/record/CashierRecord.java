package com.mapping.record;

public record CashierRecord(
        int cashierId,
        String cashierName,
        String lastName,
        String mail,
        ComputerRecord computerRecord) {
}
