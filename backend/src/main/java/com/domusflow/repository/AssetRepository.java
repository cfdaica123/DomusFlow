package com.domusflow.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.domusflow.entity.Asset;
import com.domusflow.enums.AssetStatus;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {

    @Query("SELECT a FROM Asset a LEFT JOIN FETCH a.room")
    List<Asset> findAll();

    @Query("SELECT a FROM Asset a LEFT JOIN FETCH a.room WHERE a.id = :id")
    Optional<Asset> findByIdFetchRoom(@Param("id") Long id);

    List<Asset> findByStatus(AssetStatus status);

    List<Asset> findByAssetNameContainingIgnoreCase(String assetName);

    List<Asset> findByRoomId(Long roomId);

    List<Asset> findByRoomIdAndStatus(Long roomId, AssetStatus status);

    Optional<Asset> findByAssetCode(String assetCode);
}
