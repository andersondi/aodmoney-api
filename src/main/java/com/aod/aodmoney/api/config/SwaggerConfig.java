package com.aod.aodmoney.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;

import static jdk.javadoc.doclet.DocletEnvironment.ModuleMode.API;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket( DocumentationType.SWAGGER_2)
            .select()
            .apis( RequestHandlerSelectors.basePackage("com.aod.aodmoney.api"))
            .paths( PathSelectors.any())
            .build()
            .apiInfo(apiInfo());

  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("AODmoney Spring Boot REST API")
            .description("API REST para aplicação aodmoney para cadastro de contas")
            .version("1.0.0")
            .license("Apache License Version 2.0")
            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                    .contact(new Contact("Anderson Oliveira Dias", "", "oliveiradiasa@gmail.com"))
                    .build();
  }
}

