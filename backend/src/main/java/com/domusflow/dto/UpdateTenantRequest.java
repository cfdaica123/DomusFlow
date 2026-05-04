package com.domusflow.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTenantRequest {

    private String fullName;
    private String phone;
    private String email;
    private String occupation;
    private String address;
    private String emergencyContact;
    private Boolean isActive;

    private String identityNumber;
}
