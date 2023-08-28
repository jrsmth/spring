# Spring Rest Docs
*Generate documentation for our REST controllers*

<br>

## Exercises
* [brewery-rest-docs](./exercises/brewery-rest-docs) `@SfgClone(branch="~final")` `@Modified`

<br>

## Overview
* Spring REST Docs is a tool that generates API documentation from your controller unit tests
* Asciidoctor is used to compile the documentation snippets:
    * Which is a suped-up version of markdown
    * Generally its used for documentation longer than one page

<br>

## Sounds like Swagger?
* Swagger is also a generation tool for documenting your APIs
* Swagger vs Spring REST Docs:
    * Swagger:
        * Swagger gives you 'a lot for a little'
        * You get API documentation out of the box but some would say the quality is not all it could be:
            * Swagger doesn't support hypermedia
                * Therefore a level 3 API cannot be supported:
                    * See Richarson Maturity Model: https://martinfowler.com/articles/richardsonMaturityModel.html
            * Its URI-centric
            * Heavily annotation-based, which can lead to an unpleasant writing experience
    * Spring REST Docs:
        * Requires more set-up than Swagger but offers more comprehensive documentation
        * The cornerstone of Spring REST Docs is to avoid using the implementation to provide the documentation:
            * Instead the test base is used
        * Test-Driven-Documentation: If code changes, tests change and then documentation changes automatically
* Note:
    * Whilst Spring REST Docs might be a 'better' tool, Swagger in most real-world situations does the job well enough
        * As with all things in Software Engineering, its a balance:
            * Swagger is quick, Spring REST Docs in richer
            * Useful Swagger by default, then progress to Spring REST Docs as your complexity grows
* Sources:
    * [Documenting RESTful APIs - SpringOne2GX 2015](https://www.youtube.com/watch?v=k5ncCJBarRI&t=26m58s)
    * [DZone Q&A](https://dzone.com/articles/a-qa-with-andy-wilkinson-on-spring-rest-docs)