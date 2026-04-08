package com.domusflow.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IssueStatus {
    OPEN("New Issue", "#ff9f43"), // Mới tiếp nhận
    IN_PROGRESS("In Progress", "#2e86de"), // Đang xử lý
    FIXED("Resolved (Pending Confirmation)", "#1dd1a1"), // Đã sửa, chờ xác nhận
    CLOSED("Closed", "#8395a7");             // Đã hoàn tất

    private final String displayName;
    private final String colorCode;
}
