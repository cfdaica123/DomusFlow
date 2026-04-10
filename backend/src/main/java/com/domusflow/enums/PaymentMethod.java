package com.domusflow.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentMethod {
    CASH("Cash"),
    BANK_TRANSFER("Bank Transfer"),
    E_WALLET("E-Wallet"),
    PAYMENT_GATEWAY("Online Payment"),
    CARD("Card");

    private final String displayName;
}
