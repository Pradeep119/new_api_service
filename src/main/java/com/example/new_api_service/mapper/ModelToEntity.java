package com.example.new_api_service.mapper;

import com.example.new_api_service.entity.*;
import com.example.new_api_service.model.AddApiModel;
import com.example.new_api_service.model.BackendModel;
import com.example.new_api_service.model.BackendPoolModel;
import com.example.new_api_service.util.OpenApiSpecParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ModelToEntity {

  @Mapping(target = "host" , source = "backendModel.host")
  @Mapping(target = "port" , source = "backendModel.port")
  @Mapping(target = "protocol" , source = "backendModel.protocol")
  BackendEntity backendModelToBeEntity(BackendModel backendModel);

  @Mapping(target = "name" , source = "backendPoolModel.name")
  @Mapping(target = "strategy" , source = "backendPoolModel.strategy")
  BackendPoolEntity bePoolModelToBePoolEntity(BackendPoolModel backendPoolModel);

  @Mapping(target = "apiName" , source = "addApiModel.apiName")
  @Mapping(target = "context" , source = "addApiModel.context")
  ApiEntityy apiModelToApiEntity(AddApiModel addApiModel);

  @Mapping(target = "version" , source = "addApiModel.apiVersion")
  ApiVersionEntity apiModelToApiVersionEntity(AddApiModel addApiModel);


  default ResourceEntity resourceModelToResourceEntityCustom(AddApiModel addApiModel){
     String apiSpec = addApiModel.getApiSpec();
    ResourceEntity resourceEntity = new ResourceEntity();
    String resourcePath = null;
      try {
          resourcePath = OpenApiSpecParser.parseOpenApiSpec(apiSpec);
        resourceEntity.setResourcePath(resourcePath);
      } catch (JsonProcessingException e) {
          throw new RuntimeException(e);
      }
      return resourceEntity;
  }

  default MethodEntity methodModelToMethodEntityCustom(AddApiModel addApiModel){
    String apiSpec = addApiModel.getApiSpec();
    MethodEntity methodEntity = new MethodEntity();
    String method = null;
    try {
      method = OpenApiSpecParser.parseOpenApiSpec2(apiSpec);
      methodEntity.setMethod(method);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
    return methodEntity;
  }


}
