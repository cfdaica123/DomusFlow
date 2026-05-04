package com.domusflow.service;

import java.util.List;

import com.domusflow.dto.CreateTenantRequest;
import com.domusflow.dto.TenantResponse;
import com.domusflow.dto.UpdateTenantRequest;

public interface TenantService {

    TenantResponse createTenant(CreateTenantRequest request);

    List<TenantResponse> getAllTenants();

    TenantResponse getTenantById(Long id);

    TenantResponse updateTenant(Long id, UpdateTenantRequest request);

    void deleteTenant(Long id);

    List<TenantResponse> searchTenantsByName(String name);
}
