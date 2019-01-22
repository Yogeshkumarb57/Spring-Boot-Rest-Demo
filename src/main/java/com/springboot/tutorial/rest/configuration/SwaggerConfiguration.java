package com.springboot.tutorial.rest.configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	private static final String REST_API_PACKAGE = "com.springboot.tutorial.rest";

	public static final Contact DEFAULT_CONTACT = new Contact(
		      "Yogeshkumar", "", "yogeshkumarb57@gmail.com");
		  
		  public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
		      "Spring Boot Rest API with Data JPA", "Spring Boot Rest API demo with Data JPA[H2 database]", "1.0",
		      "urn:tos", DEFAULT_CONTACT, 
		      "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");

		  private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
		      new HashSet<String>(Arrays.asList("application/json",
		          "application/xml"));

		  @Bean
		  public Docket api() {
		    return new Docket(DocumentationType.SWAGGER_2)
		    		.select()
	                //.apis(RequestHandlerSelectors.basePackage(REST_API_PACKAGE))
	                .paths(regex("/product.*"))
	                .build()
	                .apiInfo(DEFAULT_API_INFO)
	                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
	                .consumes(DEFAULT_PRODUCES_AND_CONSUMES)
					.securityContexts(Lists.newArrayList(securityContext()))
					.securitySchemes(Lists.newArrayList(apiKey()));
		  }

	private ApiKey apiKey() {
		return new ApiKey("AUTHORIZATION", "api_key", "header");
	}

	@Bean
	SecurityConfiguration security() {
		return new SecurityConfiguration(
				null,
				null,
				null, // realm Needed for authenticate button to work
				null, // appName Needed for authenticate button to work
				"BEARER ",// apiKeyValue
				ApiKeyVehicle.HEADER,
				"AUTHORIZATION", //apiKeyName
				null);
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder()
				//.securityReferences(defaultAuth())
				.forPaths(PathSelectors.regex(REST_API_PACKAGE))
				.build();
	}

	/*List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope
				= new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Lists.newArrayList(
				new SecurityReference("AUTHORIZATION", authorizationScopes));
	};*/

}

