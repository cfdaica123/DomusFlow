package com.domusflow.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Builder
public class RoomResponse {

    private Long id;
    private String roomNumber;
    private Integer floor;
    private BigDecimal price;

    private String status; 
    private String statusName;
    private String statusColor;

    private String description;
}
