# Using Swagger with Spring Boot
*Documentation for APIs*

<br>

## Exercises
* [spring5-mvc-rest](../24-restful-with-spring-mvc/exercises/spring5-mvc-rest) `@SfgClone(branch="~final")` `@Modified`

<br>

## Overview
* What is Swagger?
    * Swagger is an OSS framework backed by a large ecosystem of tools that assists developer in the design, build, documentation and consuming of RESTful web services
    * The aim of Swagger is to define a standard, language-agnostic interface to REST APIs which allows both humans and computers to discover and understand the capabilities of a web service, without direct investigation - i.e. access to the source code, written documentation or network traffic inspection
* Motive for Swagger:
    * Prior RESTful APIs, SOAP web services were very common:
        * SOAP services could include a WSDL (Web Services Decription Layer) XML document that described the contract of the endpoint
        * REST has no formal WSDL and hence the rise of Swagger for documentation
* [swagger-intro-slides.pdf](./res/swagger-intro-slides.pdf)

<br>

## Getting Started
* Add the [SpringFox](https://github.com/springfox/springfox) dependencies for Swagger to your [`pom.xml`](../24-restful-with-spring-mvc/exercises/spring5-mvc-rest/pom.xml)
    ```xml
        <springfox-swagger.version>2.7.0</springfox-swagger.version>
            ...
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>${springfox-swagger.version}</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>${springfox-swagger.version}</version>
        </dependency>
    ```
* Add a configuration class that enables Swagger (Example: [SwaggerConfig.java](../24-restful-with-spring-mvc/exercises/spring5-mvc-rest/src/main/java/guru/springfamework/config/SwaggerConfig.java))
    ```java 
        @EnableSwagger2
        @Configuration
        public class SwaggerConfig {

            @Bean
            public Docket api(){
                return new Docket(DocumentationType.SWAGGER_2)
                        .select()
                        .apis(RequestHandlerSelectors.any())
                        .paths(PathSelectors.any())
                        .build()
                        .pathMapping("/");
            } // Note :: The Docket API gives us control over what info we expose through Swagger

            // Note :: Go to http://localhost:8080/v2/api-docs for JSON info about the APIs

        }
    ```
* Going to `http://localhost:8080/v2/api-docs` reveals JSON information from Swagger about the app's APIs
    * Similarly, `http://localhost:8080/swagger-ui.html` provides a pretty UI to interact with

<br>

## Customisation Basics
* We can add meta-data to our Swagger documentation by extending the configuration class:
    ```java
        @Bean
        public Docket api(){
            return new Docket(DocumentationType.SWAGGER_2)
                    ...
                    .apiInfo(metaData());
        }

        // Note :: here we are customising the meta-data of our Swagger API docs
        private ApiInfo metaData(){
            return new ApiInfo(
                    "Spring Framework Guru",
                    "Spring Framework 5: Beginner to Guru",
                    "1.0",
                    "Terms of Service: blah",
                    new Contact(
                        "John Thompson",
                        "https://springframework.guru/about/",
                        "john@springfrmework.guru"
                    ),
                    "Apache License Version 2.0",
                    "https://www.apache.org/licenses/LICENSE-2.0",
                    new ArrayList<>()
            );
        }
    ```
* Additionally, we can add descriptions for our controller endpoints and model objects:
    * Annotations:
        * `@Api`
        * `@ApiOperation`
        * `@ApiModelProperty`
    * Example:
        * Controller:
            ```java
                //...
                @Api("This is my Customer Controller")
                public class CustomerController {

                    // ...

                    @ApiOperation(value = "This will get a list of customers.", notes = "These are some notes about the API.")
                    @GetMapping
                    @ResponseStatus(HttpStatus.OK)
                    public CustomerListDTO getListOfCustomers(){
                        return new CustomerListDTO(customerService.getAllCustomers());
                    }

                    // ...
            ```
        * Model:
            ```java
                //...
                public class CustomerDTO {

                    @ApiModelProperty(value = "This is the first name", required = true)
                    private String firstname;

                    //...
                }
            ```

<br>

## Swagger Editor
* Using the Swagger Editor we are able to develop the documentation for our APIs first, before they are implemented
    * This is a similar practise to test-driven-development, insofar as we establish the contract of our endpoints first and code towards them
* Swagger Editor: https://editor.swagger.io/
* A useful exercise is to copy the JSON response from `http://localhost:8080/v2/api-docs` into the editor and then tweak it as you see fit