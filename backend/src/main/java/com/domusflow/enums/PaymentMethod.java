package com.domusflow.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentMethod {
    CASH("Cash"),
    BANK_TRANSFER("Bank Transfer"),
    E_WALLET("E-Wallet"), // MoMo, ZaloPay, PayPal, Apple Pay...
    PAYMENT_GATEWAY("Online Payment"), // VNPay, Stripe, Razorpay...
    CARD("Card");                      // Credit + Debit

    private final String displayName;
}
