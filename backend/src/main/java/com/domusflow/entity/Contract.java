package com.domusflow.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.domusflow.common.BaseAuditEntity;
import com.domusflow.enums.ContractStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contracts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contract extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;

    @Column(nullable = false)
    private LocalDate startDate;

    private LocalDate endDate;

    @Column(precision = 12, scale = 2, nullable = false)
    private BigDecimal monthlyRent;

    @Column(precision = 12, scale = 2)
    private BigDecimal depositAmount;

    @Min(1)
    @Max(31)
    @Column(name = "payment_day")
    private Integer paymentDay;

    @Column(unique = true, length = 50)
    private String contractCode;

    private String contractUrl;

    @Column(columnDefinition = "TEXT")
    private String terms;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private ContractStatus status = ContractStatus.DRAFT;

    @Column(nullable = false)
    @Builder.Default
    private Boolean isActive = true;
}
