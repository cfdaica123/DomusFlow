package com.domusflow.service;

import java.util.List;

import com.domusflow.dto.CreateAssetRequest;
import com.domusflow.dto.UpdateAssetRequest;
import com.domusflow.entity.Asset;

public interface AssetService {

    Asset create(CreateAssetRequest request);

    Asset getById(Long id);

    List<Asset> getByStatus(String status);

    List<Asset> getByRoomAndStatus(Long roomId, String status);

    Asset update(Long id, UpdateAssetRequest request);

    void delete(Long id);
}
