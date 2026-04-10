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

    private LocalDate startDate;
    private LocalDate expectedReturnDate; 
    private LocalDate actualReturnDate;

    @Column(columnDefinition = "TEXT")
    private String reason;
    private String contactDuringAbsence;
    private String note;

    private String attachmentUrl;

    @Enumerated(EnumType.STRING)
    private RegistrationStatus status;

}
