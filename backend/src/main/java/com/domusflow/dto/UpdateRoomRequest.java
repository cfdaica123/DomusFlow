package com.domusflow.dto;
import java.math.BigDecimal;

import com.domusflow.enums.RoomStatus;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UpdateRoomRequest {

    private Integer floor;
    private BigDecimal price;
    private String description;
    private RoomStatus status;
}
