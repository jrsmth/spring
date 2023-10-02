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
        * Example:
            ```java
                class A {
                    B b;

                    // without dependency injection
                    C c = new C(?);
                    b = new B(c);
                }

                class B {
                    C c;

                    public B(C c) {
                        this.c = c;
                    }
                }
            ```
            * When we instantiate a dependency (`B`) of our class (`A`) with the `new` keyword, we tightly-couple the two classes together
            * This is because the dependent class `A` must explicitly know of `B`'s implementation in order to instantiate it (i.e. how to provide class `C`)
            * As a result, changes to `B`'s implementation risks breaking the composite class `A`
                * e.g. if `C` was removed from `B`, it would break our `A` as `b = new B(c)` would no longer be valid
            * The ability for `A` to use `B` without being concerned with its implementation is the greatest benefit of DI:
                * Allowing us to unit test `A` by mocking out `B`, reuse `B` across our application easily and make changes to `B`'s implementation without affecting `A` (providing the 'interface' that `A` interacts with remains unchanged)
* IoC Container:
    * Inversion of Control is Spring's implementation of DI and the terms can be used interchangeably
        * Control is said to be 'inverted' as the object or 'Spring Bean' defines what it needs and lets the framework source it, rather than a more traditional approach of having the class itself instantiate the dependencies it needs
    * Spring's IoC Container is responsible for instantiating, configuring, and assembling the objects to be injected as dependencies
        * The container gets its instructions on what objects to instantiate, configure, and assemble by reading configuration metadata
* Spring Beans:
    * A 'Bean' in Spring is an object that is managed by the IoC container
* Application Context:
    * `org.springframework.context.ApplicationContext` is an interface that represents Spring's IoC container, providing configuration information for the rest of your application
        * The `org.springframework.beans.factory.BeanFactory` interface provides an object pool where beans are created and managed by configuration
        * `ApplicationContext` is a wrapper of this bean factory, providing additional functionality
    * The responsibilites of the `ApplicationContext` interface include:
        * Bean Factory for application components
        * Bean Injection
        * Application Listeners
        * Logging
        * Loading config files (i.e. `.properties`, `.yaml`)
    * Creating a new instance of `ApplicationContext`:
        * Variants of the `ApplicationContext` exist within Spring:
            * `FileSystemXmlApplicationContext`
            * `ClassPathXmlApplicationContext`
            * `AnnotationConfigApplicationContext`
        * In most application scenarios, explicit user code is not required to instantiate a Spring IoC container:
            * However, one could set up an application context in the following way:
                ```java
                    ApplicationContext context = new FileSystemXmlApplicationContext(“c:/knight.xml”); 
                    ApplicationContext context = new ClassPathXmlApplicationContext(“knight.xml”); 
                    ApplicationContext context = new AnnotationConfigApplicationContext( com.springinaction.knights.config.KnightConfig.class);
                ```
            * Further [examples](https://www.geeksforgeeks.org/spring-applicationcontext/) of standing up application contexts
    * Note:
        * Multiple application contexts can exist in a single Spring application:
            * Contexts can be arranged in a parent-child hierarchy, where many child contexts can share the same parent context
        * `SpringApplication.run()` in an application's `main()` method returns an instance of `ApplicationContext`

<br>

## <a name="1.2"></a> 1.2. Java Configuration

### <a name="1.2.1"></a> 1.2.1. Define Spring Beans using Java code
* Spring Beans:
    * As mentioned above, a Spring Bean is an object that is managed by the IoC Container for the purpose of dependency injection
* Beans are created with configuration metadata that is supplied in three main forms:
    * XML-based:
        * Introduced in Spring 2
        * Still used in legacy apps but modern apps favour annotation/Java-based for readability and flexibility
        ```xml
            <?xml version="1.0" encoding="UTF-8"?>
            <beans xmlns="http://www.springframework.org/schema/beans"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:context="http://www.springframework.org/schema/context"
                xsi:schemaLocation="
                http://www.springframework.org/schema/beans
                http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
                http://www.springframework.org/schema/context
                http://www.springframework.org/schema/context/spring-context-3.0.xsd">
            
                <!-- Example Bean 1 -->
                <bean id="..." class="...">
                    <!-- dependencies and configuration for this bean go here -->
                </bean>

                <!-- Example Bean 2 -->
                <bean id="app" class="App" lazy-init="true"></bean>
                <!-- Lazy-init tells IoC container to only instantiate bean when first requested, rather than at start-up -->
            </beans>
        ```
        * This `*.xml` lives in our `/resources` and at minimum contains the bean name and a reference pointing to the class that it represents:
            * Bean names are defined using lowercase followed by camelcase - e.g `myExampleBean`
        * `@ImportResources` is applied to a class marked with `@Configuration` to include the XML config in the Component Scan:
            ```java
                @SpringBootApplication // = `@Configuration` + `@ComponentScan` + `@EnableAutoConfiguration`
                @ImportResource("classpath:beans.xml") // *.xml is arbitrary
                class MyApplication {
                    ...
                }
            ```
    * Annotation-based:
        * Introduced in Spring 3 (after annotations were added with Java 5)
        * Spring Beans are located via 'Component Scans', that search for the following class-level annotations:
            * `@Component`
            * Stereotypes: `@Controller`, `@Service`, `@Repository`
        ```java
            @Service // Such 'stereotypes' are scanned by Spring and an @Bean is created implicity
            class MyService {
                ...
            }
        ```
    * Java-based:
        * Introduced in Spring 3
        * Java classes are used to define Beans:
            * Such 'configuration' classes are annotated with `@Configuration`
            * Methods are used to return Spring Beans and are marked with `@Bean`
        ```java
            @Configuration // tells Spring that we are defining @Bean's here
            public class Config {

                @Bean // This creates an ObjectMapper bean that can be injected throughout our app
                public ObjectMapper objectMapper() {
                    return new ObjectMapper();
                }
            }
        ```
    * Extra - Groovy-based:
        * Introduced in Spring 4
        * Beans can be defined via a Groovy DSL
        * Borrowed from Grails; which is a framework built on top of Spring (using Groovy)
* Deciding upon a Bean Configuration method:
    * XML:
        * Typically used for legacy applications, where Java/Annotation-based definitions are not supported
    * Annotation (`@Component`, Stereotypes):
        * Typically used if you own the code and as such you can pick up `@Component` (etc) with a scan of your packages
    * Java (`@Configuration`, `@Bean`):
        * Typically used if you do not own the code
        * i.e. you don't have the ability to mark a class with `@Component` and scan it within your own packages
        * Example: using `ObjectMapper`, `RestTemplate`, etc
        * Note: `final` classes cannot be marked with `@Configuration` because such config classes are extended by the Spring Container:
            * This would otherwise breach the restriction on inheritance for `final` classes

<!-- What does the @Bean annotation do?

What is the default bean id if you only use @Bean? How can you override this?

Anymore? -->

<br>

### 1.2.2.
* inc Types of DI in Spring... constructor, method, field
    https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/beans.html#beans-dependencies
* manual get beans from Context
* ...