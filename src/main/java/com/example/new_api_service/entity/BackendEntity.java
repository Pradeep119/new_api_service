package com.example.new_api_service.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(
  name = "backend",
  uniqueConstraints = {
    @UniqueConstraint(columnNames = {"host", "port", "protocol"})
  }
)
public class BackendEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "backend_id")
  private int backendId;
  private String host;
  private String port;
  private String protocol;

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
    name = "backend_pool_assign_mapping",
    joinColumns =  @JoinColumn(name = "backend_id") ,
    inverseJoinColumns =  @JoinColumn(name = "pool_id") ,
    uniqueConstraints = @UniqueConstraint(columnNames = {"backend_id", "pool_id"})
  )
  Set<BackendPoolEntity> backendPoolEntities;

  public BackendEntity(int backendId, String host, String port, String protocol, Set<BackendPoolEntity> backendPoolEntities) {
    this.backendId = backendId;
    this.host = host;
    this.port = port;
    this.protocol = protocol;
    this.backendPoolEntities = backendPoolEntities;
  }

  public BackendEntity(){}

  public int getBackendId() {
    return backendId;
  }

  public void setBackendId(int backendId) {
    this.backendId = backendId;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public String getPort() {
    return port;
  }

  public void setPort(String port) {
    this.port = port;
  }

  public String getProtocol() {
    return protocol;
  }

  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  public Set<BackendPoolEntity> getBackendPoolEntities() {
    return backendPoolEntities;
  }

  public void setBackendPoolEntities(Set<BackendPoolEntity> backendPoolEntities) {
    this.backendPoolEntities = backendPoolEntities;
  }
}
