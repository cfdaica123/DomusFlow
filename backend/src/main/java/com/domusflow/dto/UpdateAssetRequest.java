package com.domusflow.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.domusflow.enums.AssetStatus;

@Getter
@Setter
@Data
public class UpdateAssetRequest {

    private String assetName;
    private AssetStatus status;
    private String brand;
    private String imageUrl;
    private BigDecimal purchasePrice;
    private String description;
    private LocalDate purchaseDate;
}
