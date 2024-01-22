package com.example.new_api_service.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.SwaggerParseResult;
import org.apache.commons.codec.binary.Base64;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OpenApiSpecParser {
  public static String parseOpenApiSpec(String encodedJsonString) throws JsonProcessingException {
    String decodedJsonString = new String(Base64.decodeBase64(encodedJsonString));
    ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
    JsonNode jsonObject = new ObjectMapper().readTree(decodedJsonString);
    String jsonAsYaml = new YAMLMapper().writeValueAsString(jsonObject);
    Object obj = yamlReader.readValue(jsonAsYaml, Object.class);
    SwaggerParseResult openAPI = new OpenAPIV3Parser().readContents(yamlReader.writeValueAsString(obj));
    return extractPathInfos(openAPI.getOpenAPI().getPaths());

  }

  private static String extractPathInfos(Paths paths) throws JsonProcessingException {
    Set<String> pathKeys = paths.keySet();
    String resourcePath = null;
    for (String pathKey : pathKeys) {
      PathItem value = paths.get(pathKey);
      Set<PathItem.HttpMethod> methodKeys = value.readOperationsMap().keySet();
      for (PathItem.HttpMethod methodKey : methodKeys) {
//        pathRequestInfo.setMethod(methodKey.toString());
        resourcePath = pathKey;
        break;
//        pathRequestInfo.setResourcePath(pathKey);
//        pathRequestInfo.setResourceId(Base64.encodeBase64String(pathKey.getBytes()));
//        pathRequestInfoList.add(pathRequestInfo);
      }
    }
    return resourcePath;
  }



  public static String parseOpenApiSpec2(String encodedJsonString) throws JsonProcessingException {
    String decodedJsonString = new String(Base64.decodeBase64(encodedJsonString));
    ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
    JsonNode jsonObject = new ObjectMapper().readTree(decodedJsonString);
    String jsonAsYaml = new YAMLMapper().writeValueAsString(jsonObject);
    Object obj = yamlReader.readValue(jsonAsYaml, Object.class);
    SwaggerParseResult openAPI = new OpenAPIV3Parser().readContents(yamlReader.writeValueAsString(obj));
    return extractPathInfos2(openAPI.getOpenAPI().getPaths());

  }

  private static String extractPathInfos2(Paths paths) throws JsonProcessingException {
    Set<String> pathKeys = paths.keySet();
    String method = null;
    for (String pathKey : pathKeys) {
      PathItem value = paths.get(pathKey);
      Set<PathItem.HttpMethod> methodKeys = value.readOperationsMap().keySet();
      for (PathItem.HttpMethod methodKey : methodKeys) {
//        pathRequestInfo.setMethod(methodKey.toString());
        method = methodKey.toString();
        break;
//        pathRequestInfo.setResourcePath(pathKey);
//        pathRequestInfo.setResourceId(Base64.encodeBase64String(pathKey.getBytes()));
//        pathRequestInfoList.add(pathRequestInfo);
      }
    }
    return method;
  }
}
