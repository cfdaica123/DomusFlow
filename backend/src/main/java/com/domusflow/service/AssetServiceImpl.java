package com.domusflow.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.domusflow.dto.AssetResponse;
import com.domusflow.dto.CreateAssetRequest;
import com.domusflow.dto.UpdateAssetRequest;
import com.domusflow.entity.Asset;
import com.domusflow.entity.Room;
import com.domusflow.enums.AssetStatus;
import com.domusflow.mapper.AssetMapper;
import com.domusflow.repository.AssetRepository;
import com.domusflow.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;
    private final RoomRepository roomRepository;

    @Override
    public AssetResponse create(CreateAssetRequest request) {

        Room room = roomRepository.findById(request.getRoomId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found"));

        if (request.getAssetCode() != null
                && assetRepository.findByAssetCode(request.getAssetCode()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Asset code already exists");
        }

        Asset asset = AssetMapper.toEntity(request, room);
        asset.setStatus(AssetStatus.ACTIVE);

        return AssetMapper.toResponse(assetRepository.save(asset));
    }

    @Override
    public AssetResponse findById(Long id) {

        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Asset not found"));

        return AssetMapper.toResponse(asset);
    }

    @Override
    public List<AssetResponse> findAll() {
        return assetRepository.findAll()
                .stream()
                .map(AssetMapper::toResponse)
                .toList();
    }

    @Override
    public List<AssetResponse> find(Long roomId, AssetStatus status) {

        List<Asset> assets;

        if (roomId != null && status != null) {
            assets = assetRepository.findByRoomIdAndStatus(roomId, status);
        } else if (roomId != null) {
            assets = assetRepository.findByRoomId(roomId);
        } else if (status != null) {
            assets = assetRepository.findByStatus(status);
        } else {
            assets = assetRepository.findAll();
        }

        return assets.stream()
                .map(AssetMapper::toResponse)
                .toList();
    }

    @Override
    public List<AssetResponse> searchByName(String name) {
        if (name == null || name.isBlank()) {
            return List.of();
        }

        return assetRepository
                .findByAssetNameContainingIgnoreCase(name.trim())
                .stream()
                .map(AssetMapper::toResponse)
                .toList();
    }

    @Override
    public AssetResponse update(Long id, UpdateAssetRequest request) {

        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Asset not found"));

        AssetMapper.updateEntity(asset, request);

        return AssetMapper.toResponse(assetRepository.save(asset));
    }

    @Override
    public void delete(Long id) {

        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Asset not found"));

        assetRepository.delete(asset);
    }
}
