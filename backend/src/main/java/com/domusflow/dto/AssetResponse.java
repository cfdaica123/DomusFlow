package com.domusflow.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AssetResponse {
    private Long id;
    private Long roomId;
    private String roomNumber;

    private String assetName;
    private String assetCode;
    private String brand;
    private BigDecimal purchasePrice;
    private String imageUrl;
    private String description;
    private LocalDate purchaseDate;

    private String status;
    private String statusName;
    private String statusColor;
}
