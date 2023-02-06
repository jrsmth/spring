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
* JUnit 4:
    * Annotations:
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
* JUnit 5:
    * Backwards Compatibility:
        * JUnit 5's `vintage` library allows the JUnit 5 test runner to run JUnit 4 tests
    * Updated Annotations:
        * `@Before` -> `@BeforeEach`
        * `@After` -> `@AfterEach`
        * `@BeforeClass` -> `@BeforeAll`
        * `@AfterClass` -> `@AfterAll`
        * `@Ignore` -> `@Disabled`
        * `@Category` -> `@Tag`
        * `@RunWith()` -> `@ExtendWith()`

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

<br>

## Mockito
* Common Features:
    * `@Mock`: 
        * Creates and injects a mocked object into the annotated field
    * `MockitoAnnotations.openMocks(this)`:
        * Enables Mockito annotations programmatically; typically called in the `@Before setUp()` method
            * Alternatively, you can annotate the JUnit test class with `@RunWith(MockitoJUnitRunner.class)`
    * `when(mockedObject.doSomething()).thenReturn(returnValue)`:
        * Allows you to supply a return value for a method call on your mocked object
    * `verify(mockedObject, times(numberOfInvocations)).doSomething()`:
        * Verifies the number of invocations of a particular method on your mocked object
    * Argument Captor:
        * Allows you to intercept an argument that is passed to a method on your mocked object, so you can inspect it
            * Good [Article](https://www.baeldung.com/mockito-argumentcaptor)
        * Steps:
            ```java
                // Test set-up
                ...

                when(mockObject.doSomething()).thenReturn(value);
                ArgumentCaptor<Type> argumentCaptor = ArgumentCaptor.forClass(Type.class);

                // Exercise behaviour under test
                ...

                // Make assertions
                ...
                
                verify(mockObject, times(numberOfInvocations)).doSomething(argumentCaptor.capture());

                Type argument = argumentCaptor.getValue();
                assertEquals(expected, argument);
            ```
* Example: [`IndexControllerTest.java`](../07-spring-mvc-web-dev/exercises/recipes/src/test/java/com/jrsmiffy/springguru/recipes/controller/IndexControllerTest.java)


<br>

## Spring MockMVC
* `MockMVC` is a feature of Spring Test that allows us to write tests for controllers without explicitly starting a Servlet container
    * It allows us to write unit tests for controllers, by mocking up the Servlet Context
* `MockMVC` offers us two modes (use standalone where possible):
    * Standalone: Unit Test - runs without a proper web context
    * Web Context: Integration Test - runs with a web context (expensive)
* Typically, we would use `MockMVC` to test media types, response codes, request mappings, etc, without bringing up the whole Spring Context
* Example:
    ```java
        @Test
        public void testMockMVC() throws Exception {
            MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();

            mockMvc.perform(get("/"))
                    .andExpect(status().isOk())
                    .andExpect(view().name(TEMPLATE));
        }
    ```

<br>

## Maven Plugins
* `maven-surefire-plugin`:
    * Runs unit tests and if any of the tests fail then it will fail the build immediately
    * `mvn test`
* `maven-failsafe-plugin`:
    * Runs integration tests, and decouples failing the build if there are test failures from actually running the tests
    * `mvn verify`
* Example: [`pom.xml`](../07-spring-mvc-web-dev/exercises/recipes/pom.xml)
* [Docs](https://maven.apache.org/surefire/maven-failsafe-plugin/faq.html#:~:text=maven%2Dsurefire%2Dplugin%20is%20designed,from%20actually%20running%20the%20tests.)