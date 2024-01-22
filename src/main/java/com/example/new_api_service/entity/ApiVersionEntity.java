package com.example.new_api_service.entity;

import jakarta.persistence.*;

@Entity
@Table(
  name = "api_version",
  uniqueConstraints = {
    @UniqueConstraint(columnNames = {"api_version", "context"})
  }
)
public class ApiVersionEntity {

  @Id
  @Column( name = "api_id")
  @GeneratedValue(strategy = GenerationType.UUID)
  private String apiId;

  @Column(name = "api_version")
  private String version;

  @ManyToOne
  @JoinColumn(name = "context", referencedColumnName = "context", nullable = false)
  private ApiEntityy apiEntityy;

  @ManyToOne
  @JoinColumn(name = "pool_id", referencedColumnName = "pool_id")
  private BackendPoolEntity pool;

  public ApiVersionEntity(String apiId, String version, ApiEntityy apiEntityy, BackendPoolEntity pool) {
    this.apiId = apiId;
    this.version = version;
    this.apiEntityy = apiEntityy;
    this.pool = pool;
  }

  public ApiVersionEntity(){}

  public String getApiId() {
    return apiId;
  }

  public void setApiId(String apiId) {
    this.apiId = apiId;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public ApiEntityy getApiEntityy() {
    return apiEntityy;
  }

  public void setApiEntityy(ApiEntityy apiEntityy) {
    this.apiEntityy = apiEntityy;
  }

  public BackendPoolEntity getPool() {
    return pool;
  }

  public void setPool(BackendPoolEntity pool) {
    this.pool = pool;
  }
}
