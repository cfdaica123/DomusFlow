package com.domusflow.service;

import java.math.BigDecimal;
import java.util.List;

import com.domusflow.dto.CreateRoomRequest;
import com.domusflow.dto.RoomResponse;
import com.domusflow.dto.UpdateRoomRequest;
import com.domusflow.enums.RoomStatus;

public interface RoomService {
    List<RoomResponse> getAll();

    RoomResponse create(CreateRoomRequest request);

    RoomResponse getById(Long id);

    List<RoomResponse> getByStatus(RoomStatus status);

    List<RoomResponse> getByFloor(Integer floor);

    List<RoomResponse> getByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    RoomResponse update(Long id, UpdateRoomRequest request);

    List<RoomResponse> searchByRoomNumber(String roomNumber);

    void delete(Long id);
}
