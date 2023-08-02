# RESTful Web Services with Spring MVC
*Exposing and consuming REST API's with Spring MVC*

<br>

## Exercises
* [spring5-mvc-rest](./exercises/spring5-mvc-rest) `@SfgClone(branch="~final")` `@Modified`

<br>

## MapStruct
* MapStruct is a Java code generator that is used to map beans
    * It helps to reduce the boilerplate code for type conversions between your model and your command/transfer/commons objects
* Advice from SFG:
    * For small projects, you can probably get away with exposing your domain objects directly through rest APIs
    * However, as projects grow, he has seen a tendency for the domain objects to develop in complexity and be unsuited for direct exposure to the outside world
        * This is where you would introduce your data transfer layer (be warned: DTO's do not have the best reputation)
* Performing type conversions manually is the most resource-efficient way but MapStruct is more convienient for the developers
    * Like with many areas of Software Engineering, it is a question of trade-offs
* In the code base, we define an interface that MapStruct will use at build-time to create the objects we need
    * MapStruct is used to replace manual conversion classes
    * All we have to define are the two different classes that represent the same object (model vs transfer) and the `@Mapper` interface linking the two
    * Example: [`CustomerMapper.java`](./exercises/spring5-mvc-rest/src/main/java/guru/springfamework/api/v1/mapper/CustomerMapper.java)
        * The generated code can be viewed in the `/target/classes` folder - example: [`CustomerMapperImpl.class`](./exercises/spring5-mvc-rest/target/classes/guru/springfamework/api/v1/mapper/CustomerMapperImpl.class)
* Note:
    * There is a handy IDE plugin for MapStruct ('MapStruct Support')
    * Care must be taken to ensure Lombok and MapStruct play nicely together (something about conflicting annotation processors)
        * Example: [`pom.xml`](./exercises/spring5-mvc-rest/pom.xml)