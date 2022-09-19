# Section 3: Dependency Injection With Spring
*Description*

<br>

## Exercises
* [RM if unnec.](./exercises/introduction)

<br>

## The SOLID Principles of OOP
* Dr Bob's five principles of effective object-oriented design:

#### Single Responsibility
* Each class should have exactly one responsiblility
* This is broken if a class has more than one reason to change
* In general, classes should be small; large classes should be split into smaller ones
* Note, the class-level has been used to illustrate the point here but the same applies from the field and method levels all the way up to the level of micro-services

#### Open Closed
* Classes should be open for extension but closed to modification
* This means that you can extend the functionality of a class, without modifying the exisiting functionality
* Use abstract base classes, where appropriate
* Use encapsulation - adding public getters and setters, where appropriate

#### Liskov Substitution
* Liskov Substitution states that: 
    * If `B` is a child of `A`, we should be able to replace `A` with `B`, without disrupting the behaviour of the program.
* In other words, you should be able to substitute a parent class with its child.

#### Interface Segregation
* Make fine-grained interfaces that are client-specific
* Many client-specific interfaces are better than one general-purpose interface
* Keep components focused on a single responsibility and minimise dependence between them

#### Dependency Inversion
* Abstractions should not depend on details; Details (concrete implementations) should depend on abstractions
* High-level modules should not import anything from low-level modules. Both should depend on abstractions (e.g., interfaces)
* Note, this is not the same Dependency Injection; which is how objects obtain their dependencies at runtime

<br>

* Summary:
    * A key theme of SOLID is to avoid the tight-coupling of software components
        * This makes code more maintainable, easier to test and easier to extend over time
    * Software development is about trade-offs:
        * We should be pragmatic when using SOLID, rather dogmatic