# Section 6: Externalising Properties
*Externalising properties to enable behavioural change in different environments*

<br>

## Exercises
* [Dependency Injection [Section 3]](../03-dependency-injection/exercises/dependency-injection) 

<br>

## Overview
* It is best practise to store configuration data in the environment so we can change an application's behaviour without a rebuild
    * This allows a single immutable artefact to move through each environment on its way to production
    * We should avoid hard-coding any value that is subject to change
* Externalising configuration is also a good idea for security reasons:
    * We can avoid checking in credentials into our code repository if they exist outside of the codebase
* Candidate properties:
    * User credentials
    * API keys
    * URLs
    * Paths
    * Queue names
* Externalisation Methods:
    * Property files (`.properties`, `.yaml`)
    * Command-line arguments
    * `SPRING_APPLICATION_JSON`
    * JNDI
    * OS Environment variables
* Property Hierachy:
    * There exists a hierachy of externalisation options such that properties will be overwritten depending on the precedence of the method with which they are defined
        1. (lowest priority) Properties define in the JAR/WAR `.properties`/`.yaml` files
        2. External property files on the file system
        3. Profile specific properties files (in JAR, then external)
        4. OS Environment variables
        5. Java system properties
        6. JNDI
        7. `SPRING_APPLICATION_JSON`
        8. Command-line arguments
        9. (highest priority) Test properties (for test setup)
* Pragmatic Guide to Hierachy:
    * Use the default profile `.properties`/`.yaml` files, where possible
    * Use profile specific `.properties`/`.yaml` files, for profile specific config only
    * Use environment variables (either at the platform [k8s] or OS levels, etc) for sensitive config, like passwords
* Spring Cloud Config:
    * Is a further option for cloud environments, where Spring applications obtain config from a configuration server
        * Out of scope for this course

<br>

## @PropertySource
* The `@PropertySource` annotation allows us to specify a source of properties in an external file and load them into the Spring Context
* We can reference properties that defined in external files by loading the file into the Spring Context with `@PropertySource`
    * `@PropertySource` is applied at the class-level, to classes marked with `@Configuration`
* The `@Value` annotation is used to reference individual properties with Spring Expression Language, SpEL (`${}`)
    * Example: `@PropertySource("classpath:datasource.properties")`
* `@PropertySource` [example](../03-dependency-injection/exercises/dependency-injection/src/main/java/com/jrsmiffy/springguru/dependencyinjection/config/GreetingServiceConfig.java)