package com.domusflow.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Priority {
    LOW("Low", "#6c757d"),
    MEDIUM("Medium", "#17a2b8"),
    HIGH("High", "#ffc107"),
    URGENT("Urgent", "#dc3545");

    private final String displayName;
    private final String colorCode;
}
