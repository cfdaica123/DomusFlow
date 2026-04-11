package com.domusflow.mapper;

import com.domusflow.dto.RoomResponse;
import com.domusflow.entity.Room;

public class RoomMapper {

    public static RoomResponse toResponse(Room room) {
        if (room == null) {
            return null;
        }

        var status = room.getStatus();

        return RoomResponse.builder()
                .id(room.getId())
                .roomNumber(room.getRoomNumber())
                .floor(room.getFloor())
                .price(room.getPrice())
                .status(status != null ? status.name() : null)
                .statusName(status != null ? status.getDisplayName() : null)
                .statusColor(status != null ? status.getColorCode() : null)
                .description(room.getDescription())
                .build();
    }
}
