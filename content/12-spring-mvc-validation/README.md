# Validation & Constraints with Spring MVC
*Handling situations where the user strays from the happy path*

<br>

## Exercises
* [Recipes [Section 7]](../07-spring-mvc-web-dev/exercises/recipes)

<br>

## Exception Handling in Spring MVC
* Common HTTP Status Codes:
    * Note: this was also discussed in [Section 7](https://github.com/JRSmiffy/spring/tree/main/content/07-spring-mvc-web-dev)
    * Codes:
        * `5XX` - Server Error :: generally indicates an unhandled exception
            * `500 Internal Server Error`
        * `4XX` - Client Error:: generally indicates a checked exception
            * `400 Bad Requesst`
            * `401 Unauthorised`
            * `404 Not Found`
            * `405 Method Not Allowed`
* Spring MVC Features:
    * `@ResponseStatus`:
        * Allows you to annotate custom exception classess to indicate to the framework the HTTP status that you wish to return when that exception is thrown
            * This is global to the application
    * `@ExceptionHandler`:
        * Allows you to define custom exception handling and is applied at the controller level
            * Can be used with `@ResponseStatus` to just return a HTTP status
            * Can be used to return a specific view
            * Can be used to take total control and work with the Model and View
                * Note: 'Model' cannot be a parameter of an ExceptionHandler method
    * `HandlerExceptionResolver`:
        * An interface with Spring MVC that you can implement for custom exception handling
            * However, custom implementations are uncommon because of Spring's robust exception handling
            * If a custom implementation is used, its typically done in conjuction with Spring's `Ordered` interface
                * Thus, defining the order the handlers will run in
        * Note: 'Model' is not passed into the `resolveException()` method, limiting its capability in this regard
        * Internal to Spring MVC, there are three implementations of the `HandlerExceptionResolver` interface:
            * `DefaultHandlerExceptionResolver` :: converts standard Spring exceptions to HTTP status codes
                * Note: this is internal to Spring MVC
            * `ExceptionHandlerExceptionResolver` :: matches uncaught exceptions to `@ExceptionHandler`
            * `ResponseStatusExceptionResolver` :: looks for uncaught exceptions matching `@ResponseStatus`
    * `SimpleMappingExceptionResolver`:
        * A Spring Bean that you can define to map exceptions to specific views
        * The exception class name is defined (without a package) and the view name
            * It is optional to define a default error page
* GRoT for when to use each feature:
    * If just setting the HTTP Status, use `@ResponseStatus`
    * If redirecting to a view, use `SimpleMappingExceptionResolver`
    * If doing both of the above, use `@ExceptionHandler` on the controller
        * `@ExceptionHandler` offers the most granular control 

<br>

## Not Found Exception Example
* In the 'Recipes' app, a [NotFoundException](../07-spring-mvc-web-dev/exercises/recipes/src/main/java/com/jrsmiffy/springguru/recipes/exception/NotFoundException.java) is defined:
    * The exception has a `@ResponseStatus` that triggers a `404 NOT FOUND` response when it is thrown
* In the [RecipeServiceImpl](../07-spring-mvc-web-dev/exercises/recipes/src/main/java/com/jrsmiffy/springguru/recipes/service/RecipeServiceImpl.java), the `NotFoundException()` is thrown when a call to the repository is made on an id that doesn't exist
* This is caught by an `@ExceptionHandler` method in the [RecipeControler](../07-spring-mvc-web-dev/exercises/recipes/src/main/java/com/jrsmiffy/springguru/recipes/controller/RecipeController.java):
    * It returns a [view](../07-spring-mvc-web-dev/exercises/recipes/src/main/resources/templates/not-found-error.html) with error data pertaining to the invalid ID

<br>

## Controller Advice
* `@ControllerAdvice` is a class-level annotation that allows us to define instances of `@ExceptionHandler` with a global scope
    * This allows exception handling to be shared across controllers; thereby reducing duplicated logic
* Example: [ControllerExceptionHandler](../07-spring-mvc-web-dev/exercises/recipes/src/main/java/com/jrsmiffy/springguru/recipes/controller/ControllerExceptionHandler.java)