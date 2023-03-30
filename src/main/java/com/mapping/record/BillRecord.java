package com.mapping.record;

import java.util.Date;

public record BillRecord(Long billId, Date billDate, Double billTotal) {
}
