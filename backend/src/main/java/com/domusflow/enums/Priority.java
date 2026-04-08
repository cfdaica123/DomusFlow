package com.domusflow.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Priority {
    LOW("Low", "#6c757d"), // Việc không gấp
    MEDIUM("Medium", "#17a2b8"), // Mức bình thường
    HIGH("High", "#ffc107"), // Cần xử lý sớm
    URGENT("Urgent", "#dc3545");     // Khẩn cấp, xử lý ngay

    private final String displayName;
    private final String colorCode;
}
