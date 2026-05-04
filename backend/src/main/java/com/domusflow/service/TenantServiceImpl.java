package com.domusflow.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domusflow.dto.CreateTenantRequest;
import com.domusflow.dto.TenantResponse;
import com.domusflow.dto.UpdateTenantRequest;
import com.domusflow.entity.Tenant;
import com.domusflow.mapper.TenantMapper;
import com.domusflow.repository.TenantRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;
    private final TenantMapper tenantMapper;

    @Override
    @Transactional
    public TenantResponse createTenant(CreateTenantRequest request) {

        if (request.getPhone() != null
                && tenantRepository.findByPhone(request.getPhone()).isPresent()) {
            throw new RuntimeException("Phone number is already in use");
        }

        if (request.getIdentityNumber() != null
                && tenantRepository.existsByIdentityNumber(request.getIdentityNumber())) {
            throw new RuntimeException("This identification number is already in use");
        }

        if (request.getEmail() != null
                && tenantRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already in use");
        }
        
        Tenant tenant = tenantMapper.toEntity(request);
        return tenantMapper.toResponse(tenantRepository.save(tenant));
    }

    @Override
    public List<TenantResponse> getAllTenants() {
        return tenantRepository.findAll()
                .stream()
                .map(tenantMapper::toResponse)
                .toList();
    }

    @Override
    public TenantResponse getTenantById(Long id) {
        Tenant tenant = tenantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tenant not found with id: " + id));

        return tenantMapper.toResponse(tenant);
    }

    @Override
    @Transactional
    public TenantResponse updateTenant(Long id, UpdateTenantRequest request) {

        Tenant tenant = tenantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tenant not found with id: " + id));

        if (request.getFullName() != null) {
            tenant.setFullName(request.getFullName());
        }

        if (request.getPhone() != null
                && !request.getPhone().equals(tenant.getPhone())
                && tenantRepository.findByPhone(request.getPhone()).isPresent()) {
            throw new RuntimeException("Phone number is already in use");
        }

        if (request.getPhone() != null) {
            tenant.setPhone(request.getPhone());
        }

        if (request.getIdentityNumber() != null
                && !request.getIdentityNumber().equals(tenant.getIdentityNumber())
                && tenantRepository.existsByIdentityNumber(request.getIdentityNumber())) {
            throw new RuntimeException("This identification number is already in use");
        }

        if (request.getIdentityNumber() != null) {
            tenant.setIdentityNumber(request.getIdentityNumber());
        }

        if (request.getEmail() != null
                && !request.getEmail().equals(tenant.getEmail())
                && tenantRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already in use");
        }

        if (request.getEmail() != null) {
            tenant.setEmail(request.getEmail());
        }

        return tenantMapper.toResponse(tenantRepository.save(tenant));
    }

    @Override
    @Transactional
    public void deleteTenant(Long id) {

        if (!tenantRepository.existsById(id)) {
            throw new RuntimeException("Tenant not found with id: " + id);
        }

        tenantRepository.deleteById(id);
    }

    @Override
    public List<TenantResponse> searchTenantsByName(String name) {

        if (name == null || name.isBlank()) {
            return List.of();
        }

        return tenantRepository.findByFullNameContainingIgnoreCase(name.trim())
                .stream()
                .map(tenantMapper::toResponse)
                .toList();
    }
}
