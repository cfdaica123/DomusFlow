package com.domusflow.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IssueStatus {
    OPEN("New Issue", "#ff9f43"),
    IN_PROGRESS("In Progress", "#2e86de"),
    FIXED("Resolved (Pending Confirmation)", "#1dd1a1"),
    CLOSED("Closed", "#8395a7");

    private final String displayName;
    private final String colorCode;
}
