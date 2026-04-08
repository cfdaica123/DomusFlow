package com.domusflow.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoomStatus {
    AVAILABLE("Vacant", "#28a745"),
    OCCUPIED("Occupied", "#007bff"),
    RESERVED("Booked (Deposit Paid)", "#ffc107"),
    MAINTENANCE("Under Maintenance", "#6c757d"),
    PENDING_EXIT("Moving Out Soon", "#17a2b8"), 
    DEBT("Payment Overdue", "#dc3545"),
    UNAVAILABLE("Locked / Not Available", "#343a40");

    private final String displayName;
    private final String colorCode;
}
