package com.example.new_api_service.model;

public class FilterModel {
  private String filterName;
  private String filterColor;

  public FilterModel(String filterName, String filterColor) {
    this.filterName = filterName;
    this.filterColor = filterColor;
  }

  public FilterModel(){}

  public String getFilterName() {
    return filterName;
  }

  public void setFilterName(String filterName) {
    this.filterName = filterName;
  }

  public String getFilterColor() {
    return filterColor;
  }

  public void setFilterColor(String filterColor) {
    this.filterColor = filterColor;
  }
}
