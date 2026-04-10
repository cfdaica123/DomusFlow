package com.domusflow.entity;
import java.math.BigDecimal;

import com.domusflow.common.BaseAuditEntity;
import com.domusflow.enums.ServiceType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "service_prices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServicePrice extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String serviceName;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal unitPrice;

    private String unit;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ServiceType type;

    private String description;

    @Builder.Default
    private Boolean isActive = true;
}
