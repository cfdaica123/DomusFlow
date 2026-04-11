package com.domusflow.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domusflow.dto.CreateAssetRequest;
import com.domusflow.dto.UpdateAssetRequest;
import com.domusflow.entity.Asset;
import com.domusflow.entity.Room;
import com.domusflow.repository.AssetRepository;
import com.domusflow.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;
    private final RoomRepository roomRepository;

    @Override
    public Asset create(CreateAssetRequest request) {

        // check room
        Room room = roomRepository.findById(request.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        // check assetCode
        if (request.getAssetCode() != null
                && assetRepository.findByAssetCode(request.getAssetCode()).isPresent()) {
            throw new RuntimeException("Asset code already exists");
        }

        Asset asset = Asset.builder()
                .room(room)
                .assetName(request.getAssetName())
                .assetCode(request.getAssetCode())
                .brand(request.getBrand())
                .purchasePrice(request.getPurchasePrice())
                .status("ACTIVE")
                .imageUrl(request.getImageUrl())
                .description(request.getDescription())
                .purchaseDate(request.getPurchaseDate())
                .build();

        return assetRepository.save(asset);
    }

    @Override
    public Asset getById(Long id) {
        return assetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset not found"));
    }

    @Override
    public List<Asset> getByStatus(String status) {
        return assetRepository.findByStatus(status);
    }

    @Override
    public List<Asset> getByRoomAndStatus(Long roomId, String status) {
        return assetRepository.findByRoomIdAndStatus(roomId, status);
    }

    @Override
    public Asset update(Long id, UpdateAssetRequest request) {

        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset not found"));

        if (request.getAssetName() != null) {
            asset.setAssetName(request.getAssetName());
        }

        if (request.getStatus() != null) {
            asset.setStatus(request.getStatus());
        }

        if (request.getBrand() != null) {
            asset.setBrand(request.getBrand());
        }

        return assetRepository.save(asset);
    }

    @Override
    public void delete(Long id) {
        if (!assetRepository.existsById(id)) {
            throw new RuntimeException("Asset not found");
        }
        assetRepository.deleteById(id);
    }
}
