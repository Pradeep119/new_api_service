package com.example.new_api_service;

import com.example.new_api_service.entity.*;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import org.hibernate.reactive.provider.ReactiveServiceRegistryBuilder;
import org.hibernate.reactive.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.hibernate.cfg.*;
import org.hibernate.service.*;

import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.CompletionStage;

@ExtendWith(VertxExtension.class)
public class TestCrudOperation {


  @Test
  void createTables(Vertx vertx, VertxTestContext context){
    Properties hibernateProps = new Properties();
    hibernateProps.put("hibernate.connection.url","jdbc:postgresql://localhost:5432/api_backend");
    hibernateProps.put("hibernate.connection.username", "postgres");
    hibernateProps.put("hibernate.connection.password", "postgres");
    hibernateProps.put("javax.persistence.schema-generation.database.action", "create");

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






    //5. do something with db
    ApiEntityy apiEntityy = new ApiEntityy("myapi", "myapicontext");

    CompletionStage<Void> insertionResult = sessionFactory.withTransaction((s, t) -> s.persist(apiEntityy));

    Future<Void> future = Future.fromCompletionStage(insertionResult);
    context.verify(() -> future
      .onFailure(err -> {
        System.out.println(err);
        context.failNow(err);
      })
      .onSuccess(r -> {
        System.out.println("Task id after insersion is: "+ apiEntityy.getApiName());
        context.completeNow();
      })

    );

  }




  @Test
  void createTenantBySchema(Vertx vertx, VertxTestContext context){
    Properties hibernateProps = new Properties();
    hibernateProps.put("hibernate.connection.url","jdbc:postgresql://localhost:5432/api_backend");
    hibernateProps.put("hibernate.connection.username", "postgres");
    hibernateProps.put("hibernate.connection.password", "postgres");
    hibernateProps.put("javax.persistence.schema-generation.database.action", "create");
//    hibernateProps.put("hibernate.vertx.pool.class", CustomSqlClientPool.class.getName());
    hibernateProps.put("hibernate.multiTenancy", "SCHEMA");

    Configuration hibernateConfiguration = new Configuration();
    hibernateConfiguration.setProperties(hibernateProps);
    hibernateConfiguration.addAnnotatedClass(ApiEntityy.class);

    ServiceRegistry serviceRegistry = new ReactiveServiceRegistryBuilder()
      .applySettings(hibernateConfiguration.getProperties()).build();

    Stage.SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory(serviceRegistry).unwrap(Stage.SessionFactory.class);






    //5. do something with db
    ApiEntityy apiEntityy = new ApiEntityy("myapi", "myapicontext");

    CompletionStage<Void> insertionResult = sessionFactory.withTransaction(UUID.randomUUID().toString() , (s, t) -> s.persist(apiEntityy));

    Future<Void> future = Future.fromCompletionStage(insertionResult);
    context.verify(() -> future
      .onFailure(err -> {
        System.out.println(err);
        context.failNow(err);
      })
      .onSuccess(r -> {
        System.out.println("Task id after insersion is: "+ apiEntityy.getApiName());
        context.completeNow();
      })

    );

  }














}
