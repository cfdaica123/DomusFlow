package com.domusflow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAssetRequest {

    private String assetName;
    private String brand;
    private String status;
}
