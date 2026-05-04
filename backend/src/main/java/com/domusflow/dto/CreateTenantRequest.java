package com.domusflow.dto;

import java.time.LocalDate;

import com.domusflow.enums.Gender;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTenantRequest {

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Phone number is required")
    private String phone;

    private String email;

    @NotBlank(message = "Identity number is required")
    private String identityNumber;

    private LocalDate birthDate;
    private Gender gender;
    private String occupation;
    private String address;
    private String emergencyContact;
}
