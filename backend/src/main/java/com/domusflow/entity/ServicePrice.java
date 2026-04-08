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
    private String serviceName; // Examples: "Household electricity", "Tap water"

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal unitPrice;

    private String unit; // "kWh" for electricity, "m3" for water, "month" for wifi...

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ServiceType type; // ELECTRICITY, WATER, OTHER...

    private String description;

    @Builder.Default
    private Boolean isActive = true;
}
