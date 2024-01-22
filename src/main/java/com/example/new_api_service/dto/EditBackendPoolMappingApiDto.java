package com.example.new_api_service.dto;

public class EditBackendPoolMappingApiDto {
  private int poolId;
  private String apiId;

  public EditBackendPoolMappingApiDto(int poolId, String apiId) {
    this.poolId = poolId;
    this.apiId = apiId;
  }

  public EditBackendPoolMappingApiDto() {
  }

  public int getPoolId() {
    return poolId;
  }

  public void setPoolId(int poolId) {
    this.poolId = poolId;
  }

  public String getApiId() {
    return apiId;
  }

  public void setApiId(String apiId) {
    this.apiId = apiId;
  }
}
