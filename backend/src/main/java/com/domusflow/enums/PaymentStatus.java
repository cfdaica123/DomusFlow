package com.domusflow.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentStatus {

    PENDING("Pending"),
    SUCCESS("Successful"), 
    FAILED("Failed"),
    CANCELLED("Cancelled"),
    REFUNDED("Refunded");

    private final String displayName;
}
