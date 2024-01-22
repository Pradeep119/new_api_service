package com.example.new_api_service.dto;

public class EditBackendDto {
  private int backendId;
  private String host;
  private String port;
  private String protocol;

  public EditBackendDto(int backendId, String host, String port, String protocol) {
    this.backendId = backendId;
    this.host = host;
    this.port = port;
    this.protocol = protocol;
  }

  public EditBackendDto() {
  }

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
}
