package com.example.new_api_service.model;

public class BackendPoolModel {
  private String name;
  private String strategy;

  public BackendPoolModel(String name, String strategy) {
    this.name = name;
    this.strategy = strategy;
  }

  public BackendPoolModel(){}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStrategy() {
    return strategy;
  }

  public void setStrategy(String strategy) {
    this.strategy = strategy;
  }
}
