package com.example.new_api_service.dto;

public class EditMethodDto {
  private int resourceId;
  private int methodId;
  private String method;

  public EditMethodDto(int resourceId, int methodId, String method) {
    this.resourceId = resourceId;
    this.methodId = methodId;
    this.method = method;
  }

  public EditMethodDto(){}

  public int getResourceId() {
    return resourceId;
  }

  public void setResourceId(int resourceId) {
    this.resourceId = resourceId;
  }

  public int getMethodId() {
    return methodId;
  }

  public void setMethodId(int methodId) {
    this.methodId = methodId;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }
}
