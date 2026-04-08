package com.domusflow.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.domusflow.common.BaseAuditEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "utility_records")
@Getter
@Setter
public class UtilityRecord extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    // Electricity/Water Meter
    private Double oldElectricIndex;
    private Double newElectricIndex;

    private Double oldWaterIndex;
    private Double newWaterIndex;

    private LocalDateTime recordingDate;

    // --- Part for Python AI Service ---
    private String electricImageUrl;
    private String waterImageUrl;

    @Column(precision = 5, scale = 2)
    private BigDecimal electricAiConfidence;

    @Column(precision = 5, scale = 2)
    private BigDecimal waterAiConfidence;

    @Column(columnDefinition = "TEXT")
    private String aiRawJson;

    private Boolean isVerified = false;

    // Thêm trường này để biết khách nào đang ở thời điểm ghi số (đối chất)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id")
    private Tenant tenantAtRecording;
}
