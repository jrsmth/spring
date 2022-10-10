# Section 5: Spring Configuration
*Defining Spring Beans and modifying their behaviour*

<br>

## Exercises
* [Dependency Injection [Section 3]](../03-dependency-injection/exercises/dependency-injection) 

<br>

## Spring Configuration Options
* XML-based Configuration:
    * Introduced in Spring 2
    * Still commonly used in legacy apps
        * However, now the industry has moved on to Java/Annotation-based configurations 
            * These are more readable and flexible
* Annotation-based Configuration:
    * Introduced in Spring 3 (after annotations were added with Java 5)
    * Spring Beans are found via 'Component Scans'
        * Component Scans locate Beans via class-level annotations:
            * Such as: `@Component`, `@Controller`, `@Service`, `Repository`
* Java-based Configuration:
    * Introduced in Spring 3
    * Java classes are used to define Beans
        * Such 'configuration' classes are annotated with `@Configuration`
        * Methods are used to return Spring Beans and are marked with `@Bean`
* Groovy-based Configuration:
    * Introduced in Spring 4
    * Beans can be defined via a Groovy DSL
        * Borrowed from Grails; which is a framework built on top of Spring (using Groovy)

<br>

## Spring Stereotypes
* Spring Stereotypes are class-level annotations that define Spring Beans
    * When annotated classes are detected via the Component Scan, an instance of the class is added to the Spring Context
* The available Stereotypes are:
    * `@Component`
    * `@Controller`
    * `@RestController`
    * `@Repository`
    * `@Service`

<img src="./res/spring-stereotypes.png" width="800">

* The `@Controller`, `@Repository` and `@Service` annotations inherit from `@Component`
    * Functionally, there is no difference between them
* `@RestController` adds `@ResponseBody` to methods in your controller, ensuring they return JSON by default

<br>

## Component Scans
* `@ComponentScan` searches for class-level stereotype annotations; these identify beans to be loaded into the Spring Context
* `@SpringBootApplication` defines an automatic component scan on the package where the annotation is used, plus all of its sub-packages
    * If you want to scan a package outside of the base package, you need to to specify it using `@ComponentScan(basePackages={})`
        * Good [article](https://www.springboottutorial.com/spring-boot-and-component-scan)
* Component Scan [demo](../03-dependency-injection/exercises/dependency-injection/src/main/java/com/jrsmiffy/springguru/dependencyinjection/DependencyInjectionApplication.java)