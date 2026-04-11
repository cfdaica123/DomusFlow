package com.domusflow.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.domusflow.dto.AssetResponse;
import com.domusflow.dto.CreateRoomRequest;
import com.domusflow.dto.RoomResponse;
import com.domusflow.dto.UpdateRoomRequest;
import com.domusflow.entity.Room;
import com.domusflow.enums.RoomStatus;
import com.domusflow.mapper.AssetMapper;
import com.domusflow.mapper.RoomMapper;
import com.domusflow.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public List<RoomResponse> getAll() {
        return roomRepository.findAll()
                .stream()
                .map(RoomMapper::toResponse)
                .toList();
    }

    @Override
    public RoomResponse create(CreateRoomRequest request) {

        roomRepository.findByRoomNumber(request.getRoomNumber())
                .ifPresent(r -> {
                    throw new RuntimeException("Room number already exists");
                });

        Room room = Room.builder()
                .roomNumber(request.getRoomNumber())
                .floor(request.getFloor())
                .price(request.getPrice())
                .description(request.getDescription())
                .status(RoomStatus.AVAILABLE)
                .build();

        return RoomMapper.toResponse(roomRepository.save(room));
    }

    @Override
    public RoomResponse getById(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        return RoomMapper.toResponse(room);
    }

    @Override
    public List<RoomResponse> getByStatus(RoomStatus status) {
        return roomRepository.findByStatus(status)
                .stream()
                .map(RoomMapper::toResponse)
                .toList();
    }

    @Override
    public List<RoomResponse> getByFloor(Integer floor) {
        return roomRepository.findByFloor(floor)
                .stream()
                .map(RoomMapper::toResponse)
                .toList();
    }

    @Override
    public List<RoomResponse> getByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice) {
        return roomRepository.findByPriceBetween(minPrice, maxPrice)
                .stream()
                .map(RoomMapper::toResponse)
                .toList();
    }

    @Override
    public RoomResponse update(Long id, UpdateRoomRequest request) {

        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        if (request.getFloor() != null) {
            room.setFloor(request.getFloor());
        }

        if (request.getPrice() != null) {
            room.setPrice(request.getPrice());
        }

        if (request.getDescription() != null) {
            room.setDescription(request.getDescription());
        }

        if (request.getStatus() != null) {
            room.setStatus(request.getStatus());
        }

        return RoomMapper.toResponse(roomRepository.save(room));
    }

    @Override
    public void delete(Long id) {
        if (!roomRepository.existsById(id)) {
            throw new IllegalArgumentException("Room not found");
        }
        roomRepository.deleteById(id);
    }

    @Override
    public List<RoomResponse> searchByName(String name) {
        if (name == null || name.isBlank()) {
            return List.of();
        }

        return roomRepository
                .findByRoomNumberContainingIgnoreCase(name.trim())
                .stream()
                .map(RoomMapper::toResponse)
                .toList();
    }
}
