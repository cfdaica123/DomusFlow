package com.domusflow.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAssetRequest {

    private Long roomId;
    private String assetName;
    private String assetCode;
    private String brand;
    private BigDecimal purchasePrice;
    private String imageUrl;
    private String description;
    private LocalDate purchaseDate;
}
