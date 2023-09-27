# 1. Spring Core

<br>

## <a name="1.1"></a> 1.1. Introduction to Spring Framework

<br>

<img src="../res/spring-overview.png" width="600px">

#### Overview
* Spring is a framework that enables developers to build web applications in Java or Kotlin
* Spring takes care of many low-level aspects of building enterprise-grade applications
    * Allowing us to focus on business features rather than boiler plate code
* Spring Facts:
    * The Spring Framework was created by Rod Johnson in 2003
    * It is an open-source project that is currently maintain by VMWare

#### Structure
* The Spring Framework is split into 5 modules:
    * `Core`: Supports core features - dependency injection (DI), validation, i18n and aspect-oriented programming
    * `Data Access`: Supports JTA (Java Transaction API), JPA (Java Persistence API) and JDBC (Java Database Connectivity)
    * `Web`: Supports the Servlet API (Spring MVC) and Reactive API (Spring WebFlux)
    * `Integration`: Supports application integration through JMS (Java Messaging Service)
    * `Testing`: Support for unit and integration testing by way of mocking, fixtures, context management and caching
* An ecosystem of 'Spring Projects' has been developed that is built upon Spring Framework:
    * `Spring Boot`: Provides opinionated starters for creating Spring projects, plus an embedded server (e.g Tomcat)
    * `Spring Cloud`: Provides patterns for distributed systems, such as Service Discovery, Circuit Breaker and API gateway
    * `Spring Security`: Provides robust authentication and authorization management
    * `Spring Mobile`: Provides capability to detect runtime device and adapt behaviour accordingly
    * `Spring Batch`: Provides a lightweight framework to develop batch applications for enterprise systems(e.g data archiving)

#### Dependency Injection
* One of the main advantages of using Spring is dependency injection (DI):
    * DI is the ability to have dependencies of a class (i.e. instances of objects that our class is composed of, called "fields") automatically provided at runtime, without us having to explicitly instantiate them in code
        * In other words:
            * `In Spring, objects define their associations (dependencies) and do not worry about how they will get those dependencies. It is the responsibility of Spring to provide the required dependencies for creating objects.`
    * This enables the developer to create loosely-coupled applications, so that individual components of the software are easier to maintain, reuse and test
    * The ability to avoid the tight-coupling of software components is a key theme of the [SOLID](https://github.com/JRSmiffy/spring/tree/main/content/03-dependency-injection#the-solid-principles-of-oop) principles of object-oriented design
* IoC Container:
    * Inversion of Control is Spring's implementation of DI and the terms can be used interchangeably
        * Control is said to be 'inverted' as the object or 'Spring Bean' defines what it needs and lets the framework source it, rather than a more traditional approach of having the class itself instantiate the dependencies it needs
    * Spring's IoC Container is responsible for instantiating, configuring, and assembling the objects to be injected as dependencies
        * The container gets its instructions on what objects to instantiate, configure, and assemble by reading configuration metadata
* Spring Beans:
    * A 'Bean' in Spring is an object that is managed by the IoC container
* Application Context:
    * `org.springframework.context.ApplicationContext` is an interface that represents Spring's IoC container, providing configuration information for the rest of your application
    * The responsibilites of the ApplicationContext interface include:
        * Bean Factory for application components
        * Bean Injection
        * Application Listeners
        * Logging
        * Loading config files (i.e. `.properties`, `.yaml`)
    * Note:
        * `SpringApplication.run()` in an application's `main()` method returns an instance of `ApplicationContext`

<br>

## <a name="1.2"></a> 1.2. Java Configuration

### <a name="1.2.1"></a> 1.2.1. Define Spring Beans using Java code
* Spring Beans...
* Types of DI in Spring...

### 1.2.2.
* ...