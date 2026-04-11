package com.domusflow.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.domusflow.dto.CreateRoomRequest;
import com.domusflow.dto.RoomResponse;
import com.domusflow.dto.UpdateRoomRequest;
import com.domusflow.enums.RoomStatus;
import com.domusflow.service.RoomService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;
    
    @GetMapping
    public ResponseEntity<List<RoomResponse>> getAll() {
        return ResponseEntity.ok(roomService.getAll());
    }

    @PostMapping
    public ResponseEntity<RoomResponse> create(@RequestBody CreateRoomRequest request) {
        return ResponseEntity.ok(roomService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(roomService.getById(id));
    }

    @GetMapping("/status")
    public ResponseEntity<List<RoomResponse>> getByStatus(@RequestParam RoomStatus status) {
        return ResponseEntity.ok(roomService.getByStatus(status));
    }

    @GetMapping("/floor")
    public ResponseEntity<List<RoomResponse>> getByFloor(@RequestParam Integer floor) {
        return ResponseEntity.ok(roomService.getByFloor(floor));
    }

    @GetMapping("/price")
    public ResponseEntity<List<RoomResponse>> getByPrice(
            @RequestParam BigDecimal min,
            @RequestParam BigDecimal max) {

        return ResponseEntity.ok(roomService.getByPriceBetween(min, max));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomResponse> update(
            @PathVariable Long id,
            @RequestBody UpdateRoomRequest request) {

        return ResponseEntity.ok(roomService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        roomService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<RoomResponse>> searchByName(@RequestParam String roomNumber) {
        return ResponseEntity.ok(roomService.searchByName(roomNumber));
    }
}
