package com.domusflow.entity;

import java.math.BigDecimal;

import com.domusflow.enums.RoomStatus;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String roomNumber;

    private Integer floor;

    @Column(precision=12, scale=2)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private RoomStatus status;
    
    private String description;
}
