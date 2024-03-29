# Using MySQL with Spring Boot
*Best practises for working with MySQL and Spring Boot*

<br>

## Exercises
* [Recipes [Section 7]](../07-spring-mvc-web-dev/exercises/recipes)

<br>

## Overview
* [MySQL Introduction](./res/IntroductionToMySQL.pdf)
* [Useful SQL Commands](../misc/sql-c.md)

<br>

## Best Practises
* Separate Databases:
    * To maintain data integrity, you should use separate databases for each environment, e.g `app-dev`, `app-prod`
* Service Accounts:
    * For security purposes, you should avoid connecting to the MySQL instance via the `root` user
    * Instead, service accounts should be created that follow the [principle of least privilege](https://csrc.nist.gov/glossary/term/least_privilege#:~:text=Definition(s)%3A,needs%20to%20perform%20its%20function.)
        * Service accounts created to allow your spring boot app to connect to MySQL should have DML-access but not DDL-access
            * They should be able to manipulate the data (Data Manipulation Language) but not modify the database structure (Data Definition Language)
* Example:
    * DEV:
        * [`schema-dev.sql`](../07-spring-mvc-web-dev/exercises/recipes/src/main/resources/schema-dev.sql)
        * [`application-dev.yaml`](../07-spring-mvc-web-dev/exercises/recipes/src/main/resources/application-dev.yaml)
    * PROD:
        * [`schema-prod.sql`](../07-spring-mvc-web-dev/exercises/recipes/src/main/resources/schema-prod.sql)
        * [`application-prod.yaml`](../07-spring-mvc-web-dev/exercises/recipes/src/main/resources/application-prod.yaml)