# Testing Spring Applications
*Writing tests for Spring Applications*

<br>

## Exercises
* [Recipes [Section 7]](../07-spring-mvc-web-dev/exercises/recipes)

<br>

## Overview
* Terminology:
    * Unit-Under-Test / System-Under-Test / etc:
        * The specific code that is being covered / exercised by your test
    * Test Fixture:
        * The set of objects with a fixed state that are used as the base line for running our tests in a repeatable way
            * This includes our mocked dependencies, test data, etc
    * Unit Test:
        * A test to verify the behaviour of an isolated section of code
        * Unit tests should execute very quickly, as they will have no external dependencies
        * Unit tests should focus on testing specific business logic within our code base
    * Integration Test:
        * A test to verify the behaviour of multiple software units working in tandem
        * Integration tests will be slower to run than unit tests, as there will be external dependencies
            * For example, loading the Spring Context
        * Integration tests should focus on testing the interactions between software components
            * Tests are much slower when we need to load the Spring Context
                * So we should avoid using integration tests where unit tests would be more appropriate
    * Functional / End-to-end Test (e2e):
        * A test that verifies the behaviour of a particular user flow from start to finish
        * The application will be tested as a whole
    * Test-Driven Development (TDD):
        * Tests are written first to define the functionality, the implementation code is written to pass the test
    * Behaviour-Driven Development (BDD):
        * Builds upon TDD, adding that tests should focus on one specific behaviour of the software unit under test
            * Tests are typically structured following the 'given, when, then' layout
    * Mock:
        * A fake implementation of a class used for testing
    * Spy:
        * A partial mock, allowing you to override select methods of the class it represents

<br>

## JUnit
* JUnit 4 Annotations:
    * `@Test`:
        * Identifies a method as a test method
    * `@Before`:
        * Executed before each test; used to prepare the test environment
    * `@After`:
        * Executed after each test; used to clean-up the test environment
    * `@BeforeClass`:
        * Executed once, before the start of all tests in the class; annotated method needs to be `static`
    * `@AfterClass`:
        * Executed once, after the end of all tests in the class; annotated method needs to be `static`
    * `@Ignore`:
        * Marks a test as disabled
    * `@Test(expected = Exception.class)`:
        * Sets the expectation that given exception should be thrown within the test
    * `@Test(timeout = 10)`:
        * Sets a timeout expectation for the test; will fail if exceeded

<br>

## Spring Boot
* Spring Boot Test Annotations:
    * `@RunWith(SpringRunner.class)`:
        * Runs a test with the Spring Context
    * `@SpringBootTest`:
        * Searches the Spring Boot Application for configuration
    * `@TestConfiguration`:
        * Allows you to specify configuration for your test
    * `@MockBean`:
        * Injects a Mockito Mock into your test class
    * `@SpyBean`:
        * Injects a Mockito Spy into your test
    * `@JsonTest`:
        * Creates a Jackson or Gson object mapper via Spring Boot
    * `@WebMvcTest`:
        * Used to test web context without a full http server
    * `@DataJpaTest`:
        * Used to test data layer with an embedded database
    * `@JdbcTest`:
        * Like `@DataJpaTest` but does not configure entity manager (testing direct SQL)
    * `@DataMongoTest`:
        * Configures an embedded MongoDB for testing
    * `@RestClientTest`:
        * Creates a mock server for testing rest clients
    * `@AutoConfigureRestDocs`:
        * Allows you to use Spring Rest Docs in tests, creating API documentation
    * `@BootStrapWith`:
        * Used to configure how the test context is boostrapped
    * `@ContextConfiguration`:
        * Used to direct Spring on how to configure the context for the test
    * `@ContextHierachy`:
        * Allows you to create a context hierachy with `@ContextConfiguration`
    * `@ActiveProfiles`:
        * Allows you to set which Spring Profiles are active for the test
    * `@TestPropertySource`:
        * Configures property sourcess for the test
    * `@DirtiesContext`:
        * Resets the Spring Context after the test; note, this is an expensive operation
    * `@WebAppConfiguration`:
        * Indicates Spring should use a Web Application Context
    * `@TestExecutionListeners`:
        * Allows you to specify listeners for testing events
    * `@Transactional`:
        * Run test in transaction; will rollback when complete by default
    * `@BeforeTransaction`:
        * Action to run before starting a transaction
    * `@AfterTransaction`:
        * Actiont to run after finishing a transaction
    * `@Commit`:
        * Specifies the transaction should be committed after the test
    * `@Rollback`:
        * Specifies that the transaction should be rolled back after the test; which is the default action
    * `@Sql`:
        * Specify SQL scripts to run before the test
    * `@SqlConfig`:
        * Define meta-data for SQL scripts that are run before the test
    * `@SqlGroup`:
        * Groups together related `@Sql` annotations
    * `@Repeat`:
        * Repeats a test a specified number of times
    * `@Timed`:
        * Similar to JUnit's `@Timeout` but will wait for the test to complete (unlike with JUnit)
    * `@IfProfileValue`:
        * Indicates test is enabled for a specific testing environment
    * `@ProfileValueSourceConfiguration`:
        * Specify a profile value source