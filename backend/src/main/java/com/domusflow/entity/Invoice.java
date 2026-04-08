package com.domusflow.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.domusflow.common.BaseAuditEntity;
import com.domusflow.enums.InvoiceStatus;

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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "invoices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invoice extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Unique invoice code for tracking
    @Column(unique = true, length = 50)
    private String invoiceCode;

    // Related contract
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;

    @Column(nullable = false)
    private LocalDate invoiceDate;

    @Column(nullable = false)
    private LocalDate dueDate;

    // Fee breakdown
    @Column(precision = 12, scale = 2)
    private BigDecimal roomAmount;

    @Column(precision = 12, scale = 2)
    private BigDecimal electricityAmount;

    private Integer oldElectricityIndex;
    private Integer newElectricityIndex;

    @Column(precision = 12, scale = 2)
    private BigDecimal waterAmount;

    @Column(precision = 12, scale = 2)
    private BigDecimal otherServicesAmount;

    @Column(precision = 12, scale = 2, nullable = false)
    private BigDecimal totalAmount;

    // Invoice status (UNPAID, PARTIAL, PAID, OVERDUE, CANCELLED)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InvoiceStatus status;

    @Column(columnDefinition = "TEXT")
    private String note;
}
