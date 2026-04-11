package com.domusflow.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domusflow.entity.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
    
    List<Asset> findByRoomIdAndStatus(Long roomId, String status);
    List<Asset> findByStatus(String status);

    Optional<Asset> findByAssetCode(String assetCode);
}
