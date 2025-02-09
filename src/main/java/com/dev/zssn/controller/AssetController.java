package com.dev.zssn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.zssn.dto.AssetDto;
import com.dev.zssn.services.AssetService;

@RestController
public class AssetController {

  final Logger LOGGER = LoggerFactory.getLogger(SurvivorController.class);

  private final AssetService assetService;

  public AssetController(AssetService assetService) {
    this.assetService = assetService;
  }

  @GetMapping("/assets")
  public ResponseEntity<List<AssetDto>> all() {
    try {
      final List<AssetDto> assets = this.assetService.all();
      return new ResponseEntity<>(assets, HttpStatus.OK);
    } catch (Exception e) {
      LOGGER.error(e.getMessage());
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/assets")
  public ResponseEntity<AssetDto> addAsset(@RequestBody final AssetDto assetDto) {
    try {
      final AssetDto asset = this.assetService.addAsset(assetDto);
      return new ResponseEntity<>(asset, HttpStatus.CREATED);
    } catch (Exception e) {
      LOGGER.error(e.getMessage());
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
}
