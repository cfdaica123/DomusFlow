package com.domusflow.service;

import java.util.List;

import com.domusflow.dto.AssetResponse;
import com.domusflow.dto.CreateAssetRequest;
import com.domusflow.dto.UpdateAssetRequest;
import com.domusflow.enums.AssetStatus;

public interface AssetService {

    List<AssetResponse> findAll();

    AssetResponse findById(Long id);

    AssetResponse create(CreateAssetRequest request);

    AssetResponse update(Long id, UpdateAssetRequest request);

    void delete(Long id);

    List<AssetResponse> find(Long roomId, AssetStatus status);

    List<AssetResponse> searchByName(String name);
}
