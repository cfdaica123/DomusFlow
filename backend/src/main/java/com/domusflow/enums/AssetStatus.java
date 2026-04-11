package com.domusflow.enums;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AssetStatus {
    ACTIVE("Active", "#28a745"),
    INACTIVE("Inactive", "#dc3545");

    private final String displayName;
    private final String colorCode;
}
