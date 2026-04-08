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
    private Tenant tenant; // Người gửi yêu cầu

    @Column(nullable = false)
    private String title; // Ví dụ: "Hỏng vòi hoa sen"

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description; // Chi tiết tình trạng hỏng

    private String evidenceImageUrl; // Ảnh chụp chỗ hỏng để chủ trọ kiểm tra trước

    @Enumerated(EnumType.STRING)
    private MaintenanceStatus status = MaintenanceStatus.PENDING;

    private Integer priority; // 1: Gấp, 2: Bình thường, 3: Có thể đợi

    private LocalDateTime scheduledAt; // Hẹn giờ qua sửa
    private LocalDateTime completedAt; // Thời điểm sửa xong thực tế

    @Column(columnDefinition = "TEXT")
    private String resolutionNote; // Ghi chú của thợ hoặc chủ trọ sau khi sửa xong
}
