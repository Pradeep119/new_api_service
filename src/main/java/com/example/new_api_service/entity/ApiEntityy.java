package com.example.new_api_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "api")
public class ApiEntityy {

  @Column(name = "api_name")
  private String apiName;

  @Id
  private String context;

  public ApiEntityy(String apiName, String context) {
    this.apiName = apiName;
    this.context = context;
  }

  public ApiEntityy(){}

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ApiEntityy apiEntityy = (ApiEntityy) o;
    return Objects.equals(apiName, apiEntityy.apiName) && Objects.equals(context, apiEntityy.context);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiName, context);
  }
}
