package com.domusflow.dto;

import java.time.LocalDate;

import com.domusflow.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TenantResponse {

    private Long id;
    private String fullName;
    private String phone;
    private String email;
    private String identityNumber;
    private LocalDate birthDate;
    private Gender gender;
    private String occupation;
    private boolean isActive;
}
