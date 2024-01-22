package com.example.new_api_service.dto;

public class EditFilterMappingApiDto {
  private int filterId;
  private String apiId;

  public EditFilterMappingApiDto(int filterId, String apiId) {
    this.filterId = filterId;
    this.apiId = apiId;
  }

  public EditFilterMappingApiDto() {
  }

  public int getFilterId() {
    return filterId;
  }

  public void setFilterId(int filterId) {
    this.filterId = filterId;
  }

  public String getApiId() {
    return apiId;
  }

  public void setApiId(String apiId) {
    this.apiId = apiId;
  }
}
