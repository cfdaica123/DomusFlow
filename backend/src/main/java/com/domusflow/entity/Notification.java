package com.domusflow.entity;

import com.domusflow.common.BaseAuditEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User recipient; // Người nhận thông báo

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String type; // Ví dụ: INVOICE, MAINTENANCE, AI_OCR, SYSTEM

    private String targetUrl; // Link để nhấn vào xem chi tiết (ví dụ: link tới hóa đơn)

    private Boolean isRead = false;

    private java.time.LocalDateTime readAt;
}
