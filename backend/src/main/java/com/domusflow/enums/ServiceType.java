package com.domusflow.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ServiceType {
    METERED("Calculated based on meter readings (Electricity, Water)"),
    FIXED("Fixed monthly fees (Wifi, Trash)"),
    PER_PERSON("Calculated based on the number of people living there."),
    PER_UNIT("Calculated using different units of use."); // Example: number of cubic meters, parking space

    private final String description;
}
