package com.domusflow.entity;

import java.math.BigDecimal;

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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "assets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asset extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room; // Tài sản này thuộc phòng nào (null nếu là đồ dùng chung/kho)

    @Column(nullable = false)
    private String assetName; // Tên: "Điều hòa Inverter", "Giường gỗ xoan đào"

    private String assetCode; // Mã quản lý: ví dụ DF-R101-AC01

    private String brand; // Thương hiệu (Daikin, Samsung...)

    @Column(precision = 12, scale = 2)
    private BigDecimal purchasePrice; // Giá lúc mua (để tính khấu hao)

    private String status; // Tình trạng: "Mới", "Đang sử dụng", "Hỏng", "Đã thanh lý"

    private String imageUrl; // Ảnh chụp tài sản làm bằng chứng lúc bàn giao

    @Column(columnDefinition = "TEXT")
    private String description; // Mô tả chi tiết (ví dụ: "Có vết trầy ở góc tủ")

    private java.time.LocalDate purchaseDate; // Ngày mua
}
