package com.fastcampus.helloswagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    public static final String API_TITLE = "Hello Swagger API";
    public static final String API_DESCRIPTION = "샘플 프로젝트 API 명세서입니다.";
    public static final String API_VERSION = "v0.1";
    public static final String API_GROUP_NAME = "hello-swagger-public";

    @Bean
    public GroupedOpenApi groupedOpenApi() {
        String[] paths = {"/**"};
        return GroupedOpenApi.builder()
                .group(API_GROUP_NAME)
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info().title(API_TITLE)
                        .description(API_DESCRIPTION)
                        .version(API_VERSION)
                );
    }
}
