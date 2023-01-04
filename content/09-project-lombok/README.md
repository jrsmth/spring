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

## Features
* Variables:
    * `val`: allows us to declare a final local variable without specifying the type
    * `var`: allows us to declare a mutable local variable without specifying the type
* Null Checking:
    * `@NonNull`: Null-checks a parameter and will throw a NPE if it is `null`
* Clean Up:
    * `@Cleanup`: Will call `close()` on a resource in a finally block
* Getters and Setters:
    * `@Getter`: Creates 'getters' for all properties of the class
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