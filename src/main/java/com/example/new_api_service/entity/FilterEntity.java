package com.example.new_api_service.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "filter")
public class FilterEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "filter_id")
  private int filterId;
  private String name;
  private String color;

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
    name = "filter_api_mapping",
    joinColumns = @JoinColumn(name = "filter_id") ,
    inverseJoinColumns =  @JoinColumn(name = "api_id") ,
    uniqueConstraints = @UniqueConstraint(columnNames = {"filter_id", "api_id"})
  )
  Set<ApiVersionEntity> apiVersionEntities;

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
    name = "filter_resource_mapping",
    joinColumns =  @JoinColumn(name = "filter_id") ,
    inverseJoinColumns =  @JoinColumn(name = "resource_id") ,
    uniqueConstraints = @UniqueConstraint(columnNames = {"filter_id", "resource_id"})
  )
  Set<ResourceEntity> resourceEntities;

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
    name = "filter_method_mapping",
    joinColumns =  @JoinColumn(name = "filter_id") ,
    inverseJoinColumns =  @JoinColumn(name = "method_id") ,
    uniqueConstraints = @UniqueConstraint(columnNames = {"filter_id", "method_id"})
  )
  Set<MethodEntity> methodEntities;


  public FilterEntity(int filterId, String name, String color, Set<ApiVersionEntity> apiVersionEntities, Set<ResourceEntity> resourceEntities, Set<MethodEntity> methodEntities) {
    this.filterId = filterId;
    this.name = name;
    this.color = color;
    this.apiVersionEntities = apiVersionEntities;
    this.resourceEntities = resourceEntities;
    this.methodEntities = methodEntities;
  }

  public FilterEntity() {
  }

  public int getFilterId() {
    return filterId;
  }

  public void setFilterId(int filterId) {
    this.filterId = filterId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public Set<ApiVersionEntity> getApiVersionEntities() {
    return apiVersionEntities;
  }

  public void setApiVersionEntities(Set<ApiVersionEntity> apiVersionEntities) {
    this.apiVersionEntities = apiVersionEntities;
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
