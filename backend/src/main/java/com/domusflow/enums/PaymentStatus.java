package com.domusflow.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentStatus {

    PENDING("Pending"), // Payment created but not completed
    SUCCESS("Successful"), // Payment completed successfully
    FAILED("Failed"), // Payment failed
    CANCELLED("Cancelled"), // User/system cancelled
    REFUNDED("Refunded");        // Money returned to payer

    private final String displayName;
}
