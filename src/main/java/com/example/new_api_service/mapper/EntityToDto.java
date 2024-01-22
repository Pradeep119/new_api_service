package com.example.new_api_service.mapper;

import com.example.new_api_service.dto.*;
import com.example.new_api_service.dto.EditBackendDto;
import com.example.new_api_service.dto.EditBackendPoolDto;
import com.example.new_api_service.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EntityToDto {

  @Mapping(target = "context" , source = "apiEntityy.context")
  @Mapping(target = "apiId" , source = "apiVersionEntity.apiId")
  @Mapping(target = "version" , source = "apiVersionEntity.version")
  AddApiDto apiEntityToAddApiDto(ApiEntityy apiEntityy, ApiVersionEntity apiVersionEntity);

  @Mapping(target = "backendId" , source = "backendEntity.backendId")
  @Mapping(target = "host" , source = "backendEntity.host")
  @Mapping(target = "port" , source = "backendEntity.port")
  @Mapping(target = "protocol" , source = "backendEntity.protocol")
  AddBackendDto backendEntityToAddBackendDto(BackendEntity backendEntity);

  @Mapping(target = "poolId" , source = "backendPoolEntity.poolId")
  @Mapping(target = "strategy" , source = "backendPoolEntity.strategy")
  AddBackendPoolDto bePoolEntityToAddBePoolDto(BackendPoolEntity backendPoolEntity);

  @Mapping(target = "filterId" , source = "filterEntity.filterId")
  @Mapping(target = "color" , source = "filterEntity.color")
  AddFilterDto filterEntityToAddFilterDto(FilterEntity filterEntity);


  @Mapping(target = "apiId" , source = "apiVersionEntity.apiId")
  @Mapping(target = "resourceId" , source = "resourceEntity.resourceId")
  @Mapping(target = "resourcePath" , source = "resourceEntity.resourcePath")
  AddResourcePathDto resourceEntityToAddResourceDto(ApiVersionEntity apiVersionEntity, ResourceEntity resourceEntity);

  @Mapping(target = "resourceId" , source = "resourceEntity.resourceId")
  @Mapping(target = "methodId" , source = "methodEntity.methodId")
  @Mapping(target = "method" , source = "methodEntity.method")
  AddMethodDto methodEntityToAddMethodDto(ResourceEntity resourceEntity, MethodEntity methodEntity);

  @Mapping(target = "backendId" , source = "backendEntity.backendId")
  @Mapping(target = "host" , source = "backendEntity.host")
  @Mapping(target = "port" , source = "backendEntity.port")
  @Mapping(target = "protocol" , source = "backendEntity.protocol")
  EditBackendDto backendEntityToEditBackendDto(BackendEntity backendEntity);

  @Mapping(target = "poolId" , source = "backendPoolEntity.poolId")
  @Mapping(target = "strategy" , source = "backendPoolEntity.strategy")
  EditBackendPoolDto bePoolEntityToEditBePoolDto(BackendPoolEntity backendPoolEntity);


  @Mapping(target = "apiId" , source = "apiVersionEntity.apiId")
  @Mapping(target = "resourceId" , source = "resourceEntity.resourceId")
  @Mapping(target = "resourcePath" , source = "resourceEntity.resourcePath")
  EditResourcePathDto resourceEntityToEditResourceDto(ApiVersionEntity apiVersionEntity, ResourceEntity resourceEntity);

}
