package com.example.new_api_service;

import com.example.new_api_service.dto.AddApiDto;
import com.example.new_api_service.entity.*;
import com.example.new_api_service.mapper.EntityToDto;
import com.example.new_api_service.mapper.EntityToDtoImpl;
import com.example.new_api_service.mapper.ModelToEntity;
import com.example.new_api_service.mapper.ModelToEntityImpl;
import com.example.new_api_service.model.AddApiModel;
import com.example.new_api_service.model.BackendModel;
import com.example.new_api_service.model.BackendPoolMappingModel;
import com.example.new_api_service.model.BackendPoolModel;
import com.example.new_api_service.util.ApiSpecConstant;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import org.hibernate.cfg.Configuration;
import org.hibernate.reactive.provider.ReactiveServiceRegistryBuilder;
import org.hibernate.reactive.stage.Stage;
import org.hibernate.service.ServiceRegistry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Properties;
import java.util.concurrent.CompletionStage;

@ExtendWith(VertxExtension.class)
public class TestEventSending {

  Stage.SessionFactory createSession(){
    Properties hibernateProps = new Properties();
    hibernateProps.put("hibernate.connection.url","jdbc:postgresql://localhost:5432/api_backend");
    hibernateProps.put("hibernate.connection.username", "postgres");
    hibernateProps.put("hibernate.connection.password", "postgres");
    hibernateProps.put("javax.persistence.schema-generation.database.action", "create-drop");

    Configuration hibernateConfiguration = new Configuration();
    hibernateConfiguration.setProperties(hibernateProps);
//    hibernateConfiguration.addAnnotatedClass(Task.class);
    hibernateConfiguration.addAnnotatedClass(ApiEntityy.class);
    hibernateConfiguration.addAnnotatedClass(ApiVersionEntity.class);
    hibernateConfiguration.addAnnotatedClass(ResourceEntity.class);
    hibernateConfiguration.addAnnotatedClass(MethodEntity.class);
    hibernateConfiguration.addAnnotatedClass(FilterEntity.class);
    hibernateConfiguration.addAnnotatedClass(BackendPoolEntity.class);
    hibernateConfiguration.addAnnotatedClass(BackendEntity.class);

    ServiceRegistry serviceRegistry = new ReactiveServiceRegistryBuilder()
      .applySettings(hibernateConfiguration.getProperties()).build();

    Stage.SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory(serviceRegistry).unwrap(Stage.SessionFactory.class);
    return sessionFactory;
  }

  @Test
  void saveApiInDb(Vertx vertx, VertxTestContext context){
    Stage.SessionFactory sessionFactory = createSession();


    ModelToEntity modelToEntityMapper = new ModelToEntityImpl();

    //model class that coming from api request
    BackendModel backendModel = new BackendModel("localhost", "9000", "http");
    BackendPoolModel backendPoolModel = new BackendPoolModel("mypool", "round_robin");


    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    //save backend
    BackendEntity backendEntity = modelToEntityMapper.backendModelToBeEntity(backendModel);
    CompletionStage<Void> insertionResult = sessionFactory.withTransaction((s, t) -> s.persist(backendEntity));
    Future<Void> future = Future.fromCompletionStage(insertionResult);
    context.verify(() -> future
      .onFailure(err -> {
        System.out.println(err);
        context.failNow(err);
      })
      .onSuccess(r -> {
        System.out.println("backend id: "+ backendEntity.getBackendId());
        context.completeNow();
      })
    );

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }


    //save backendPool
    BackendPoolEntity backendPoolEntity = modelToEntityMapper.bePoolModelToBePoolEntity(backendPoolModel);
    CompletionStage<Void> insertionResult1 = sessionFactory.withTransaction((s, t) -> s.persist(backendPoolEntity));
    Future<Void> future1 = Future.fromCompletionStage(insertionResult1);
    context.verify(() -> future1
      .onFailure(err -> {
        System.out.println(err);
        context.failNow(err);
      })
      .onSuccess(r -> {
        System.out.println("backend pool id: "+ backendPoolEntity.getPoolId());
        context.completeNow();
      })
    );


    AddApiModel addApiModel = new AddApiModel();
    addApiModel.setApiName("testapi1");
    addApiModel.setApiVersion("v1");
    addApiModel.setContext("testcontext1");
    addApiModel.setApiSpec(ApiSpecConstant.apiSpec);
    BackendPoolMappingModel backendPoolMappingModel = new BackendPoolMappingModel(backendPoolEntity.getPoolId() , backendEntity.getBackendId());
    addApiModel.setBackendPoolMappingModel(backendPoolMappingModel);


    //ApiEntity
    ApiEntityy apiEntity = modelToEntityMapper.apiModelToApiEntity(addApiModel);
    ApiVersionEntity apiVersionEntity = modelToEntityMapper.apiModelToApiVersionEntity(addApiModel);
    ResourceEntity resourceEntity = modelToEntityMapper.resourceModelToResourceEntityCustom(addApiModel);
    MethodEntity methodEntity = modelToEntityMapper.methodModelToMethodEntityCustom(addApiModel);


    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    //save apiEntity
    CompletionStage<Void> insertionResult2 = sessionFactory.withTransaction((s, t) -> s.persist(apiEntity));
    Future<Void> future2 = Future.fromCompletionStage(insertionResult2);
    context.verify(() -> future2
      .onFailure(err -> {
        System.out.println(err);
        context.failNow(err);
      })
      .onSuccess(r -> {
        System.out.println("api context: "+ apiEntity.getContext());
        context.completeNow();
      })
    );



    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    //save apiVersionEntity
    apiVersionEntity.setPool(backendPoolEntity);
    apiVersionEntity.setApiEntityy(apiEntity);
    CompletionStage<Void> insertionResult3 = sessionFactory.withTransaction((s, t) -> s.persist(apiVersionEntity));
    Future<Void> future3 = Future.fromCompletionStage(insertionResult3);
    context.verify(() -> future3
      .onFailure(err -> {
        System.out.println(err);
        context.failNow(err);
      })
      .onSuccess(r -> {
        System.out.println("api id: "+ apiVersionEntity.getApiId());
        context.completeNow();
      })
    );



    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    //save resourceEntity
    resourceEntity.setApiVersionEntity(apiVersionEntity);
    CompletionStage<Void> insertionResult4 = sessionFactory.withTransaction((s, t) -> s.persist(resourceEntity));
    Future<Void> future4 = Future.fromCompletionStage(insertionResult4);
    context.verify(() -> future4
      .onFailure(err -> {
        System.out.println(err);
        context.failNow(err);
      })
      .onSuccess(r -> {
        System.out.println("resource id: "+ resourceEntity.getResourceId());
        context.completeNow();
      })
    );


    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    //save methodEntity
    methodEntity.setResourceEntity(resourceEntity);
    CompletionStage<Void> insertionResult5 = sessionFactory.withTransaction((s, t) -> s.persist(methodEntity));
    Future<Void> future5 = Future.fromCompletionStage(insertionResult5);
    context.verify(() -> future5
      .onFailure(err -> {
        System.out.println(err);
        context.failNow(err);
      })
      .onSuccess(r -> {
        System.out.println("method id: "+ methodEntity.getMethodId());
        context.completeNow();
      })
    );

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }







    //create dto objects
    EntityToDto entityToDtoMapper = new EntityToDtoImpl();

    AddApiDto addApiDto = entityToDtoMapper.apiEntityToAddApiDto(apiEntity, apiVersionEntity);
    System.out.println("sending add api event "+ addApiDto.toString());
  }


}
