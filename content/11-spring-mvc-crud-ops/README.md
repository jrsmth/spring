# CRUD Operations with Spring MVC
*Manipulating data through REST endpoints*

<br>

## Exercises
* [Recipes [Section 7]](../07-spring-mvc-web-dev/exercises/recipes)

<br>

## Overview
* What *even* is Spring MVC?
    * Spring MVC is a module of the Spring framework that implements the MVC design pattern
        * It combines all the advantages of the MVC pattern with the convenience of Spring
        * Spring implements MVC with the front-controller-pattern using its `DispatcherServlet`
        * The `DispatcherServlet` acts as the main controller to route requests to their intended destination
            * It handles all the HTTP requests and responses, dispatching the requests to handlers
                * `@Controller` and `@RequestMapping` are used as default request handlers
                    * The `@Controller` annotation defines that a particular class is a controller
                    * The `@RequestMapping` annotation maps web requests to Spring Controller methods
        * The 'Model' refers to the data of our application
        * The 'View' is represented by any of the various template engines (e.g Thymeleaf)
    * Summarised from the docs:
        * The Spring Web model-view-controller (MVC) framework is designed around a `DispatcherServlet` that dispatches requests to handlers
        * The default handler is based on the `@Controller` and `@RequestMapping` annotations
    * Sources:
        * [Spring MVC Docs](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html)
        * [Baeldung](https://www.baeldung.com/spring-mvc-tutorial)
        * [Geeks For Geeks](https://www.geeksforgeeks.org/spring-mvc-framework/)
* Webjars:
    * Publicly available `.jar`'s that contain popular web components (https://www.webjars.org/)
    * Similar to [Maven Cental](https://mvnrepository.com/repos/central) for getting the dependenency reference for your `pom.xml`
    * In this course, we've used the 'bootstrap' and 'jquery' webjars in our thymeleaf-driven `index.html`
        * Example: [index.html](../07-spring-mvc-web-dev/exercises/recipes/src/main/resources/templates/index.html)

<br>

## Form Posts
* Form Posts with regards to Spring MVC refers to using a 'Command Object' to bind the fields of that object to form inputs in the template
    * When data is posted to the backend, Spring MVC will automatically deserialise the form data into the desired Java object
        * A note of Serialisation: to 'serialise' to go from object to string; to 'deserialise' is to go from string to object
* Command Objects / Backing Beans:
    * Used to transfer data between a web form and the controller
* Spring MVC will automatically bind data of form posts to the fields of our Command Object
* As software projects mature, it is prudent to avoid exposing your domain objects directly to the web tier
    * I do not understand the exact reason for this at present but I believe this is what we see in TradEd:
        * With the domain model object in `traded-data-model`, representing the table entity
        * Plus, the inputs POJO version in `traded-common-utils`, used when interacting with the frontend
    * Example: 
        * [`CategoryCommand.java`](../07-spring-mvc-web-dev/exercises/recipes/src/main/java/com/jrsmiffy/springguru/recipes/command/CategoryCommand.java)
        * [`CategoryCommandToCategory.java`](../07-spring-mvc-web-dev/exercises/recipes/src/main/java/com/jrsmiffy/springguru/recipes/converter/CategoryCommandToCategory.java)
            * Note, Spring does not guarantee thread-safety and this is why Lombok's `@Synchronized` is used in the converter classes