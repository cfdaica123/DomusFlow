package com.domusflow.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRoomRequest {

    private String roomNumber;
    private Integer floor;
    private BigDecimal price;
    private String description;
}
