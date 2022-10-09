# Section 5: Spring Configuration
*Defining Spring Beans and modifying their behaviour*

<br>

## Exercises
* [This & That](./exercises/this-that)

<br>

## Spring Configuration Options
* XML-based Configuration:
    * Introduced in Spring 2
    * Still commonly used in legacy apps
        * However, now the industry has moved on to Java/Annotation-based configurations 
            * These are more readable and flexible
* Annotation-based Configuration:
    * Introduced in Spring 3 (Java 5)
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
        * Borrowed from Grails; which is built on top of Spring, using Groovy
