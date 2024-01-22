package com.example.new_api_service.entity;

import jakarta.persistence.*;

@Entity
@Table(
  name = "method",
  uniqueConstraints = {
    @UniqueConstraint(columnNames = {"resource_id", "method"})
  }
)
public class MethodEntity {

  @Id
  @Column(name = "method_id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int methodId;

  @Column(name = "method")
  private String method;

  @ManyToOne
  @JoinColumn(name = "resource_id", referencedColumnName = "resource_id", nullable = false)
  private ResourceEntity resourceEntity;

  public MethodEntity(int methodId, String method, ResourceEntity resourceEntity) {
    this.methodId = methodId;
    this.method = method;
    this.resourceEntity = resourceEntity;
  }

  public MethodEntity(){
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

  public ResourceEntity getResourceEntity() {
    return resourceEntity;
  }

  public void setResourceEntity(ResourceEntity resourceEntity) {
    this.resourceEntity = resourceEntity;
  }
}
