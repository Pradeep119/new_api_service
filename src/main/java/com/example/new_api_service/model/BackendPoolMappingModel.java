package com.example.new_api_service.model;

public class BackendPoolMappingModel {
  private int poolId;
  private int backendId;

  public BackendPoolMappingModel(int poolId, int backendId) {
    this.poolId = poolId;
    this.backendId = backendId;
  }

  public BackendPoolMappingModel(){}

  public int getPoolId() {
    return poolId;
  }

  public void setPoolId(int poolId) {
    this.poolId = poolId;
  }

  public int getBackendId() {
    return backendId;
  }

  public void setBackendId(int backendId) {
    this.backendId = backendId;
  }
}
