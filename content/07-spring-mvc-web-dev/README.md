# Spring MVC Web Development
*Building a web application with Spring MVC*

<br>

## Exercises
* [Recipes](./exercises/recipes) 

<br>

## Overview
* Spring vs Spring Boot vs Spring MVC:
    * Spring:
        * Is a dependency injection framework for building Java applications
    * Spring MVC:
        * Is a web framework built on the Java Servlet API (part of Spring Framework Core)
            * It is used to create webapps that run on Servlet containers (such as Tomcat)
    * Spring Boot:
        * An opionated configuration for Spring-based projects
            * It increases developer productivity and enables Spring-based projects to be run as standalone apps (embedded server)
    * Notes:
        * Good [video](https://www.youtube.com/watch?v=e6Ps8I3X-g4)


<br>

## Thymeleaf
* Thymeleaf is a Java templating engine:
    * It takes a template and converts it to HTML
    * It is not a Web Framework in of itself
    * It is a replacement for JSP's (Java Server Pages), which come from J2EE (Java Enterprise Edition)
* Thymeleaf is a natural template engine:
    * This means that it can be rendered in the browser (without a Tomcat server, for example)
        * This contrasts JSP's which cannot be viewed properly in the browser alone