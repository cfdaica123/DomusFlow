package com.domusflow.entity;

import com.domusflow.common.BaseAuditEntity;
import com.domusflow.enums.Gender;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
@Entity
@Table(name = "tenants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tenant extends BaseAuditEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Phone number is required")
    @Column(nullable = false, unique=true)
    private String phone;
    
    private String email;

    /**
     * Personal identification number of the tenant. Supports: 12-digit
     * Vietnamese CCCD, Japanese Zairyu Card, or Passport number.
     */
    @Column(name = "identity_number", length = 50, nullable = false, unique = true)
    @NotBlank(message = "Identity number is required")
    private String identityNumber;

    private java.time.LocalDate birthDate;

    private Gender gender;

    private String occupation;

    private String address;

    private String emergencyContact;

    private boolean isActive = true;
}
