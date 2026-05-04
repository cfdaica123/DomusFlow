package com.domusflow.mapper;

import org.springframework.stereotype.Component;

import com.domusflow.dto.CreateTenantRequest;
import com.domusflow.dto.TenantResponse;
import com.domusflow.entity.Tenant;

@Component
public class TenantMapper {

    public Tenant toEntity(CreateTenantRequest request) {
        if (request == null) {
            return null;
        }

        return Tenant.builder()
                .fullName(request.getFullName())
                .phone(request.getPhone())
                .email(request.getEmail())
                .identityNumber(request.getIdentityNumber())
                .birthDate(request.getBirthDate())
                .gender(request.getGender())
                .occupation(request.getOccupation())
                .address(request.getAddress())
                .emergencyContact(request.getEmergencyContact())
                .isActive(true)
                .build();
    }

    public TenantResponse toResponse(Tenant tenant) {
        if (tenant == null) {
            return null;
        }

        return TenantResponse.builder()
                .id(tenant.getId())
                .fullName(tenant.getFullName())
                .phone(tenant.getPhone())
                .email(tenant.getEmail())
                .identityNumber(tenant.getIdentityNumber())
                .birthDate(tenant.getBirthDate())
                .gender(tenant.getGender())
                .occupation(tenant.getOccupation())
                .isActive(tenant.isActive())
                .build();
    }
}
