# Building a Spring Boot App
*High-level introduction to Spring Boot applications*

<br>
<br>

## Exercises
* [Introductory Webapp](./exercises/introduction)

<br>
<br>

## Spring Initialzr
* Useful Links:
    * https://start.spring.io/
    * https://github.com/spring-io/start.spring.io
* Overview:
    * Spring Initializr offers us an simple UI-driven tool for creating Spring applications
        * It allows us to achieve in the order of minutes, what used to take half a day to set up
* Note:
    * IntelliJ UE allows us to create Spring Boot projects (via the Spring Initializr API), through the 'new project' wizard

<br>
<br>

## Project Management
* In the 'Introductory' exercise, we're using maven.
    * In the associated `pom.xml` we configure the project meta-data and specify the required dependencies
    * A best-practise convention is to ommit the version numbers for dependencies, where possible:
        * Instead, relying on the dependency versions that come from the `spring-boot-starter-parent` POM, as they are managed by the Spring team ('curated-dependencies')

<br>
<br>

## JPA Entities
* POJO: Plain-Old Java Object
    * There seems to be a non-trivial [discussion](https://stackoverflow.com/questions/3326319/what-is-meaning-of-plain-old-java-object-pojo) of what constitutes a POJO
    * I use the term in reference to a Java class that is not bound to a specific framework and is typically a class with fields, a constructor and getters/setters only  
        * To be precise, this is perhaps too strict a definition because it can probably also contain business logic within extra methods. 
        * However, I find myself using the term in reference to Java objects that serve as JPA entities, hence my tighter definition 
* `@Entity` is used to convert our POJO into a JPA entity
    * For our JPA entity we need to specify an ID and a generation strategy for that ID, using the following annotations:
        * `@Id`
        * `@GeneratedValue(strategy = GenerationType.AUTO)`