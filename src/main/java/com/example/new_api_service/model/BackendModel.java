package com.example.new_api_service.model;

public class BackendModel {

  private String host;
  private String port;
  private String protocol;

  public BackendModel(String host, String port, String protocol) {
    this.host = host;
    this.port = port;
    this.protocol = protocol;
  }

  public BackendModel(){}

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
