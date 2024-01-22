package com.example.new_api_service.dto;

public class EditBackendPoolDto {
  private int poolId;
  private String strategy;

  public EditBackendPoolDto(int poolId, String strategy) {
    this.poolId = poolId;
    this.strategy = strategy;
  }

  public int getPoolId() {
    return poolId;
  }

  public void setPoolId(int poolId) {
    this.poolId = poolId;
  }

  public String getStrategy() {
    return strategy;
  }

  public void setStrategy(String strategy) {
    this.strategy = strategy;
  }

  public EditBackendPoolDto() {
  }
}
