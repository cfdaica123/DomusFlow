package com.domusflow.entity;

import com.domusflow.common.BaseAuditEntity;
import com.domusflow.enums.MaintenanceStatus; // Bạn nên tạo thêm Enum này
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "maintenance_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaintenanceRequest extends BaseAuditEntity {

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
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    private String evidenceImageUrl;

    @Enumerated(EnumType.STRING)
    private MaintenanceStatus status = MaintenanceStatus.PENDING;

    private Integer priority; 

    private LocalDateTime scheduledAt;
    private LocalDateTime completedAt;

    @Column(columnDefinition = "TEXT")
    private String resolutionNote; 
}
