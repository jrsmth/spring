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