package com.domusflow.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ContractStatus {
    DRAFT("Draft"),
    ACTIVE("Active"),
    EXPIRED("Expired"),
    TERMINATED("Terminated");

    private final String displayName;
}
