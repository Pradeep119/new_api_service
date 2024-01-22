package com.example.new_api_service.dto;

public class AddApiDto {
  private String apiId;
  private String context;
  private String version;

  public AddApiDto(String apiId, String context, String version) {
    this.apiId = apiId;
    this.context = context;
    this.version = version;
  }

  public AddApiDto(){}

  public String getApiId() {
    return apiId;
  }

  public void setApiId(String apiId) {
    this.apiId = apiId;
  }

  public String getContext() {
    return context;
  }

  public void setContext(String context) {
    this.context = context;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  @Override
  public String toString() {
    return "AddApiDto{" +
      "apiId='" + apiId + '\'' +
      ", context='" + context + '\'' +
      ", version='" + version + '\'' +
      '}';
  }
}
