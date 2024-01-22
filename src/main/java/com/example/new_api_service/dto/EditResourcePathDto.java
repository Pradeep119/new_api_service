package com.example.new_api_service.dto;

public class EditResourcePathDto {
  private String apiId;
  private int resourceId;
  private String resourcePath;

  public EditResourcePathDto(String apiId, int resourceId, String resourcePath) {
    this.apiId = apiId;
    this.resourceId = resourceId;
    this.resourcePath = resourcePath;
  }

  public EditResourcePathDto(){}

  public String getApiId() {
    return apiId;
  }

  public void setApiId(String apiId) {
    this.apiId = apiId;
  }

  public int getResourceId() {
    return resourceId;
  }

  public void setResourceId(int resourceId) {
    this.resourceId = resourceId;
  }

  public String getResourcePath() {
    return resourcePath;
  }

  public void setResourcePath(String resourcePath) {
    this.resourcePath = resourcePath;
  }
}
