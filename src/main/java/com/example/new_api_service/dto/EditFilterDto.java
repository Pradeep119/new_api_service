package com.example.new_api_service.dto;

public class EditFilterDto {
  private int filterId;
  private String color;

  public EditFilterDto(int filterId, String color) {
    this.filterId = filterId;
    this.color = color;
  }

  public EditFilterDto() {
  }

  public int getFilterId() {
    return filterId;
  }

  public void setFilterId(int filterId) {
    this.filterId = filterId;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}
