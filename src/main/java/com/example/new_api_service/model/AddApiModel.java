package com.example.new_api_service.model;

public class AddApiModel {
  private String apiName;
  private String context;
  private String apiSpec;
  private String apiVersion;
  private BackendPoolMappingModel backendPoolMappingModel;

  public AddApiModel(String apiName, String context, String apiSpec, String apiVersion, BackendPoolMappingModel backendPoolMappingModel) {
    this.apiName = apiName;
    this.context = context;
    this.apiSpec = apiSpec;
    this.apiVersion = apiVersion;
    this.backendPoolMappingModel = backendPoolMappingModel;
  }

  public AddApiModel(){}

  public String getApiName() {
    return apiName;
  }

  public void setApiName(String apiName) {
    this.apiName = apiName;
  }

  public String getContext() {
    return context;
  }

  public void setContext(String context) {
    this.context = context;
  }

  public String getApiSpec() {
    return apiSpec;
  }

  public void setApiSpec(String apiSpec) {
    this.apiSpec = apiSpec;
  }

  public String getApiVersion() {
    return apiVersion;
  }

  public void setApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
  }

  public BackendPoolMappingModel getBackendPoolMappingModel() {
    return backendPoolMappingModel;
  }

  public void setBackendPoolMappingModel(BackendPoolMappingModel backendPoolMappingModel) {
    this.backendPoolMappingModel = backendPoolMappingModel;
  }
}
