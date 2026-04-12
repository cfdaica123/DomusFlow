package com.domusflow.mapper;

import com.domusflow.dto.AssetResponse;
import com.domusflow.dto.CreateAssetRequest;
import com.domusflow.dto.UpdateAssetRequest;
import com.domusflow.entity.Asset;
import com.domusflow.entity.Room;
import com.domusflow.enums.AssetStatus;

public class AssetMapper {

    public static AssetResponse toResponse(Asset asset) {
        if (asset == null) {
            return null;
        }

        AssetStatus status = asset.getStatus();

        return AssetResponse.builder()
                .id(asset.getId())
        
                .roomId(asset.getRoom() != null ? asset.getRoom().getId() : null)
                .roomNumber(asset.getRoom() != null ? asset.getRoom().getRoomNumber() : null)

                .assetName(asset.getAssetName())
                .assetCode(asset.getAssetCode())
                .brand(asset.getBrand())
                .purchasePrice(asset.getPurchasePrice())
                .imageUrl(asset.getImageUrl())
                .purchaseDate(asset.getPurchaseDate())
                .status(status != null ? status.name() : null)
                .statusName(status != null ? status.getDisplayName() : null)
                .statusColor(status != null ? status.getColorCode() : null)
                .description(asset.getDescription())
                .build();
    }

    public static Asset toEntity(CreateAssetRequest request, Room room) {
        return Asset.builder()
                .room(room)
                .assetName(request.getAssetName())
                .assetCode(request.getAssetCode())
                .brand(request.getBrand())
                .purchasePrice(request.getPurchasePrice())
                .imageUrl(request.getImageUrl())
                .description(request.getDescription())
                .purchaseDate(request.getPurchaseDate())
                .build();
    }

    public static void updateEntity(Asset asset, UpdateAssetRequest request) {

        if (request.getAssetName() != null) {
            asset.setAssetName(request.getAssetName());
        }

        if (request.getStatus() != null) {
            asset.setStatus(request.getStatus());
        }

        if (request.getBrand() != null) {
            asset.setBrand(request.getBrand());
        }

        if (request.getImageUrl() != null) {
            asset.setImageUrl(request.getImageUrl());
        }

        if (request.getPurchasePrice() != null) {
            asset.setPurchasePrice(request.getPurchasePrice());
        }

        if (request.getDescription() != null) {
            asset.setDescription(request.getDescription());
        }

        if (request.getPurchaseDate() != null) {
            asset.setPurchaseDate(request.getPurchaseDate());
        }
    }
}