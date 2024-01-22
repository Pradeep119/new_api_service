package com.example.new_api_service.DesignPattern;

import com.example.new_api_service.dto.*;
import com.example.new_api_service.entity.*;
import com.example.new_api_service.mapper.EntityToDto;
import com.example.new_api_service.mapper.EntityToDtoImpl;
import com.example.new_api_service.mapper.ModelToEntity;
import com.example.new_api_service.mapper.ModelToEntityImpl;
import com.example.new_api_service.model.AddApiModel;
import io.swagger.annotations.ApiModel;

public class AddApiDtoClass {
  public AddApiDto buildAddApiDto(){
    ModelToEntity modelToEntityMapper = new ModelToEntityImpl();
    EntityToDto entityToDtoMapper = new EntityToDtoImpl();


    AddApiModel addApiModel = new AddApiModel();

    //start transactional
    ApiEntityy apiEntityy = modelToEntityMapper.apiModelToApiEntity(addApiModel);
    ApiVersionEntity apiVersionEntity = modelToEntityMapper.apiModelToApiVersionEntity(addApiModel);



    //get APIEntity and ApiVersionEntity from db
    //compareBetweenThem



    //method() - boolean compare objects
    //method() - save entities in db
    //method() - send addApiDto event
    AddApiDto addApiDto =  entityToDtoMapper.apiEntityToAddApiDto(apiEntityy,apiVersionEntity);

    return addApiDto;
  }


  public EditResourcePathDto buildEditResourceDto(){
    ModelToEntity modelToEntityMapper = new ModelToEntityImpl();
    EntityToDto entityToDtoMapper = new EntityToDtoImpl();
    AddApiModel addApiModel = new AddApiModel();
    ResourceEntity resourceEntity = modelToEntityMapper.resourceModelToResourceEntityCustom(addApiModel);
    ApiVersionEntity apiVersionEntity = modelToEntityMapper.apiModelToApiVersionEntity(addApiModel);

    EditResourcePathDto editResourcePathDto = entityToDtoMapper.resourceEntityToEditResourceDto(apiVersionEntity, resourceEntity);
    return editResourcePathDto;
  }
}
