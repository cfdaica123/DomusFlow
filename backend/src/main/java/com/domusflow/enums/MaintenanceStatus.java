package com.domusflow.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MaintenanceStatus {
    REQUESTED("New Request"), // Khách vừa gửi yêu cầu
    PENDING("Awaiting Assignment"), // Chờ phân công thợ
    ASSIGNED("Assigned to Technician"), // Đã giao thợ
    SCHEDULED("Scheduled Visit"), // Đã hẹn lịch sửa
    IN_PROGRESS("Work in Progress"), // Đang sửa
    ON_HOLD("On Hold"), // Tạm dừng (thiếu đồ / chờ duyệt)
    COMPLETED("Completed"), // Hoàn thành
    CANCELLED("Cancelled");              // Đã hủy

    private final String description;
}
