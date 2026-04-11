package com.domusflow.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domusflow.entity.Room;
import com.domusflow.enums.RoomStatus;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Room> findByRoomNumber(String roomNumber);

    List<Room> findByStatus(RoomStatus status);

    List<Room> findByFloor(Integer floor);

    List<Room> findByPriceBetween(java.math.BigDecimal minPrice, java.math.BigDecimal maxPrice);
}
