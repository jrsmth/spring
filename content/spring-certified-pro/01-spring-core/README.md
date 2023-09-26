# 1. Spring Core

<br>

## <a name="1.1"></a> 1.1. Introduction to Spring Framework

<br>

<img src="../res/spring-overview.png" width="600px">

* Spring Framework:
    * Spring is a framework that enables developers to build web applications in Java or Kotlin
    * Spring takes care of many low-level aspects of building enterprise-grade applications
        * Allowing us to focus on business features rather than boiler plate code
* Structure:
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
        * `Spring Batch`: Provides a lightweight framework for developing batch applications for enterprise systems, like data archiving
* Spring Facts:
    * The Spring Framework was created by Rod Johnson in 2003
    * It is an open-source project that is currently maintain by VMWare

<br>

## <a name="1.2"></a> 1.2. Java Configuration

#### <a name="1.2.1"></a> 1.2.1. Define Spring Beans using Java code