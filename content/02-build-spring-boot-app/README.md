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