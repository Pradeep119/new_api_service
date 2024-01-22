package com.example.new_api_service.entity;

import jakarta.persistence.*;

@Entity
@Table(
  name = "resource_path",
  uniqueConstraints = {
    @UniqueConstraint(columnNames = {"api_id", "resource_path"})
  }
)
public class ResourceEntity {

  @Id
  @Column(name = "resource_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int resourceId;

  @Column(name = "resource_path")
  private String resourcePath;


  @ManyToOne
  @JoinColumn(name = "api_id", referencedColumnName = "api_id", nullable = false)
  private ApiVersionEntity apiVersionEntity;


  public ResourceEntity(int resourceId, String resourcePath, ApiVersionEntity apiVersionEntity) {
    this.resourceId = resourceId;
    this.resourcePath = resourcePath;
    this.apiVersionEntity = apiVersionEntity;
  }

  public ResourceEntity(){}

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

  public ApiVersionEntity getApiVersionEntity() {
    return apiVersionEntity;
  }

  public void setApiVersionEntity(ApiVersionEntity apiVersionEntity) {
    this.apiVersionEntity = apiVersionEntity;
  }
}
