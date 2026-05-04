package com.domusflow.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domusflow.entity.Tenant;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {

    Optional<Tenant> findByPhone(String phone);

    Optional<Tenant> findByIdentityNumber(String identityNumber);

    List<Tenant> findByFullNameContainingIgnoreCase(String fullName);

    List<Tenant> findByIsActive(boolean isActive);

    boolean existsByIdentityNumber(String identityNumber);

    Optional<Tenant> findByEmail(String email);
}
