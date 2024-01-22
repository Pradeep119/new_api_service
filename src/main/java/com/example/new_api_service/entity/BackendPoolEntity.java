package com.example.new_api_service.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(
  name = "backend_pool",
  uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})
  }
)
public class BackendPoolEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "pool_id")
  private int poolId;
  private String name;
  private String strategy;

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
    name = "pool_resource_mapping",
    joinColumns =  @JoinColumn(name = "pool_id") ,
    inverseJoinColumns =  @JoinColumn(name = "resource_id") ,
    uniqueConstraints = @UniqueConstraint(columnNames = {"pool_id", "resource_id"})
  )
  Set<ResourceEntity> resourceEntities;

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
    name = "pool_method_mapping",
    joinColumns =  @JoinColumn(name = "pool_id") ,
    inverseJoinColumns =  @JoinColumn(name = "method_id") ,
    uniqueConstraints = @UniqueConstraint(columnNames = {"pool_id", "method_id"})
  )
  Set<MethodEntity> methodEntities;


  public BackendPoolEntity(int poolId, String name, String strategy, Set<ResourceEntity> resourceEntities, Set<MethodEntity> methodEntities) {
    this.poolId = poolId;
    this.name = name;
    this.strategy = strategy;
    this.resourceEntities = resourceEntities;
    this.methodEntities = methodEntities;
  }

  public BackendPoolEntity(){}

  public int getPoolId() {
    return poolId;
  }

  public void setPoolId(int poolId) {
    this.poolId = poolId;
  }

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

  public Set<ResourceEntity> getResourceEntities() {
    return resourceEntities;
  }

  public void setResourceEntities(Set<ResourceEntity> resourceEntities) {
    this.resourceEntities = resourceEntities;
  }

  public Set<MethodEntity> getMethodEntities() {
    return methodEntities;
  }

  public void setMethodEntities(Set<MethodEntity> methodEntities) {
    this.methodEntities = methodEntities;
  }
}
