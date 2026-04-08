package com.domusflow.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RegistrationType {
    TEMPORARY_RESIDENCE("Temporary residence registration"),
    TEMPORARY_ABSENT("Temporary absence registration");

    private final String description;
}
