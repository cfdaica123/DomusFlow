package com.domusflow.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RegistrationStatus {
    PENDING("Pending Approval", "#ffc107"),
    APPROVED("Approved", "#28a745"),
    REJECTED("Rejected", "#dc3545");

    private final String displayName;
    private final String colorCode;
}
