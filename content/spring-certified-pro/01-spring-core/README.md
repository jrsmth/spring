# 1. Spring Core

<br>

## <a name="1.1"></a> 1.1. Introduction to Spring Framework

<br>

<img src="../res/spring-overview.png" width="600px">

<br>

* <details open>
    <summary>Spring Framework</summary>

    * Spring is a framework that enables developers to build web applications in Java or Kotlin
    * Spring takes care of many low-level aspects of building enterprise-grade applications
        * Allowing us to focus on business features rather than boiler plate code
    * Benefits & Drawbacks... <!-- TODO -->
  </details>

* <details>
    <summary>Structure</summary>

    * The Spring Framework is split into 5 modules:
        * `Core`: Provides core features such as dependency injection (DI), validation, internationalisation (i18n) and aspect-oriented programming (AOP)
        * `Data Access`: Supports data management through JTA (Java Transaction API), JPA (Java Persistence API) and JDBC (Java Database Connectivity)
        * `Web`: Supports the Servlet API (Spring MVC) and Reactive API (Spring WebFlux)
        * `Integration`: Supports application integration through JMS (Java Messaging Service)
        * `Testing`: Support for unit and integration testing by way of mocking, fixtures, context management and caching
    * An ecosystem of 'Spring Projects' has grown that is built upon Spring Framework:
        * <!-- TODO -->
  </details>

* <details>
    <summary>Facts</summary>

    * The Spring Framework was created by Rod Johnson in 2003
    * It is an open-source project that is currently maintain by VMWare
  </details>

<br>

## <a name="1.2"></a> 1.2. Java Configuration

#### <a name="1.2.1"></a> 1.2.1. Define Spring Beans using Java code