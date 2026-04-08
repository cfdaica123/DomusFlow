package com.domusflow.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InvoiceStatus {
    UNPAID("Unpaid", "#dc3545"),
    PARTIAL("Partially Paid", "#ffc107"),
    PAID("Paid", "#28a745"),
    OVERDUE("Overdue", "#6c757d"),
    CANCELLED("Cancelled", "#343a40");

    private final String displayName;
    private final String colorCode;
}
