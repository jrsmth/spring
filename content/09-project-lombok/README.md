# Project Lombok
*Spice up your Java by reducing boilerplate code*

<br>

## Exercises
* [Recipes [Section 7]](../07-spring-mvc-web-dev/exercises/recipes)

<br>

## Overview
* Like the 'Java' language, 'Lombok' is named after an island in Indonesia
    * It is also Indonesian for 'Chilli', hence the references to 'Spicy' throughout Project Lombok
* Lombok works by hooking into the Java Annotations processor API
    * At compile time, Lombok will generate the required code based on your annotations and perform the insertion automatically
* Annotation processing in IntelliJ needs to be enabled to allow the IDE to recognise Lombok annotations

<br>

## Useful Features
* Variables:
    * `val`: Allows us to declare a final local variable without specifying the type
    * `var`: Allows us to declare a mutable local variable without specifying the type
* Exceptions:
    * `@NonNull`: Null-checks a method parameter and will throw a NPE if it is `null`
    * `@SneakyThrows`: Allows us to throw checked exceptions without actually declaring them in your method's throws clause
* Clean Up:
    * `@Cleanup`: Will call `close()` on a resource in a finally block
* Getters and Setters:
    * `@Getter`: Creates 'getters' for all properties of the class
        * `@Getter(lazy=true)`: Used for expensive 'get' operations, Lombok caches the result so we don't have to repeat them on subsequent calls
    * `@Setter`: Creates 'setters' for all non-`final` properties of the class
* To String, Equals & Hash Code:
    * `@ToString`: Generates a string of the class name and comma-separated field names; optional parameters to configure output
    * `@EqualsAndHashCode`: Provides an implementation for both `equals(Object other)` and `hasCode()`
* Constructors:
    * `@NoArgsConstructor`: Generates a constructor with no arguments; will cause compilation error if there exists `final` fields
    * `@RequiredArgsConstructor`: Generates a constructor for all fields that are marked `final` or `@NonNull`
    * `@AllArgsConstructors`: Generates a constructor for all properties of the class
* POJO:
    * `@Data`: Generates the typical boilerplate code for a POJO
        * Combines: `@RequiredArgsConstructor`, `@Getter`, `@Setter`, `@ToString`, `@EqualsAndHashCode`
        * Note, no constructor is generated if one or more constructors have already been explicitly declared
    * `@Value`: The immutable variant of `@Data`; all fields are made `private` and `final`, setters are not generated and the class itself is made `final`
* Builder:
    * `@Builder`: Implements the builder pattern on your class
        * Allowing you to instantiate an object in the form: `YourClass.builder().field1(value1).field2(value2)...build();`
        * `@Builder` requires a 'proper' (non-default?) constructor; typically this means using it in conjunction with `@AllArgsConstructor`
* Synchronized:
    * `@Synchronized`: A safer implementation of Java's `synchronized()` method
        * In a multi-threaded environment, a race condition occurs when two or more threads attempt to update mutable shared data at the same time
            * Java offers a mechanism to avoid race conditions by synchronizing thread access to shared data
* Logging:
    * `@Log`: Creates a Java util logger
    * `@Slf4j`: Creates an SLF4J logger
        * Simple Logging Facade for Java (SLF4J) is an abstraction for various logging frameworks (e.g. java.util.logging, logback, etc)
            * Spring Boot uses 'logback' by default
* Experimental:
    * Lombok does ship with features in an 'experimental' package, which are not recommended for production-use

<br>

## Gotchas with Project Lombok
* `@EqualsAndHashCode`:
    * When using `@EqualsAndHashCode` on entitites with bi-directional relationships, you may encounter a `StackOverflowError`
        * It occurs when you've got a circular dependency between two classes
        * To rectify, you can exclude the related entity from the `hashCode()` method that gets generated by Lombok
            * Example: `@EqualsAndHashCode(exclude="fieldName")`
        * Good StackOverflow [post](https://stackoverflow.com/questions/34972895/lombok-hashcode-issue-with-java-lang-stackoverflowerror-null)
* `@Data`:
    * If you apply `@Data` to your Hibernate `@Entity`'s, IntelliJ will give you a warning along the lines of:
        * `Using @Data for JPA entities is not recommended. It can cause severe performance and memory consumption issues.`
            * This is related to issues caused by Lombok's implementation of `@EqualsAndHashCode` (discussed above)
            * Good [post](https://thorben-janssen.com/lombok-hibernate-how-to-avoid-common-pitfalls/) that recommends avoiding `@ToString` and `@EqualsAndHashCode` with Hibernate entities