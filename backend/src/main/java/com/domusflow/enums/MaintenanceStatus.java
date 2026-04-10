package com.domusflow.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MaintenanceStatus {
    REQUESTED("New Request"),
    PENDING("Awaiting Assignment"),
    ASSIGNED("Assigned to Technician"),
    SCHEDULED("Scheduled Visit"),
    IN_PROGRESS("Work in Progress"),
    ON_HOLD("On Hold"),
    COMPLETED("Completed"),
    CANCELLED("Cancelled");

    private final String description;
}
