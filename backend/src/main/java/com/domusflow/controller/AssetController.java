package com.domusflow.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.domusflow.dto.AssetResponse;
import com.domusflow.dto.CreateAssetRequest;
import com.domusflow.dto.UpdateAssetRequest;
import com.domusflow.enums.AssetStatus;
import com.domusflow.service.AssetService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/assets")
@RequiredArgsConstructor
public class AssetController {

    private final AssetService assetService;

    @GetMapping
    public ResponseEntity<List<AssetResponse>> getAll() {
        return ResponseEntity.ok(assetService.findAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<AssetResponse>> searchByName(
            @RequestParam("assetName") String name) {
        return ResponseEntity.ok(assetService.searchByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssetResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(assetService.findById(id));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<AssetResponse>> filter(
            @RequestParam(required = false) Long roomId,
            @RequestParam(required = false) AssetStatus status) {

        return ResponseEntity.ok(assetService.find(roomId, status));
    }

    @PostMapping
    public ResponseEntity<AssetResponse> create(
            @Valid @RequestBody CreateAssetRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(assetService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssetResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateAssetRequest request) {

        return ResponseEntity.ok(assetService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        assetService.delete(id);
        return ResponseEntity.noContent().build();
    }

    
}
