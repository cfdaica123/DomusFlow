package com.domusflow.entity;
import java.time.LocalDate;

import com.domusflow.common.BaseAuditEntity;
import com.domusflow.enums.RegistrationStatus;
import com.domusflow.enums.RegistrationType;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "stay_registrations")
@Getter
@Setter
public class StayRegistration extends BaseAuditEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RegistrationType registrationType;

    private LocalDate startDate; // Date when the tenant starts their stay
    private LocalDate expectedReturnDate; // Date when the tenant expects to return (can be null if it's a temporary residence registration without a planned return date)
    private LocalDate actualReturnDate; // Date when the tenant actually returns (can be null if not returned yet)

    @Column(columnDefinition = "TEXT")
    private String reason; // Reason for temporary absence or residence (e.g., "Going on vacation", "Going on a business trip", "Staying at a friend's house")
    private String contactDuringAbsence; // Contact number during absence (if different from main phone number)

    private String note; // Note: This field is optional and can be used to store any additional information about the stay registration, such as special instructions, comments from the tenant, or notes from the dormitory staff.

    
    private String attachmentUrl; // URL to the uploaded attachment (e.g., a photo of the tenant's ID card or a document related to the stay registration)
    
    @Enumerated(EnumType.STRING)
    private RegistrationStatus status; // Status of the stay registration (e.g., PENDING, APPROVED, REJECTED)

}
