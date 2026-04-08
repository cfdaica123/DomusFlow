package com.domusflow.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {
    ROLE_ADMIN("Chủ trọ / Quản trị viên"),
    ROLE_MANAGER("Quản lý dãy trọ"),
    ROLE_TENANT("Khách thuê");

    private final String description;
}
