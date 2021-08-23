
# Converting JUnit 5 & Selenium into TestProject coded test

**TestProject service is a great platform to use that can be very helpful for testers who want to simplify the process of creating, sharing, and maintaining existing tests.**

**TestProject brings to us the following benefits**

* No need to download chrome driver / mobile driver
* No need to set up reporting service
* No need to sync the tests with multiple tests machines (It is all on the cloud)
* Free support in our great community ( https://forum.testproject.io/ )
* Free add-ons (shared code that bundled as "Addons" and can be used in your tests)

**In this article, I will explain how to convert the JUnit 5 parameterized test into a test that can be executed with the power of TestProject. 
This way, we will be able to use all of the good stuff above that TestProject brings to us :)**


# Let's get started!

For demonstration purposes only, we will use a very simple JUnit 5 & pure selenium project and we will learn how to take this existing project and turn it into a coded test that can be executed with the TestProject platform (Agent & Service).

To get started, please clone the following simple project:

https://github.com/gil-testproject/JUnit-Parameterization-Article/tree/main/pure-junit5-and-selenium


Let’s have a look on the test class example in this project:


src\test\java\ParameterizedTestExample.java

```java
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.stream.Stream;

public class ParameterizedTestExample {

    private ChromeDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    public void loginTest(String username, String password) {

        // Navigate to TestProject Example website
        driver.navigate().to("https://example.testproject.io/web/");

        // Login using provided credentials
        driver.findElement(By.cssSelector("#name")).sendKeys(username);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.cssSelector("#login")).click();

        // Validate successful and correct login
        String actual = driver.findElement(By.cssSelector("#greetings")).getText();
        String expected = String.format("Hello %s, let's complete the test form:", username);
        Assertions.assertEquals(expected, actual);
    }


    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of("User1", "12345"),
                Arguments.of("User2", "12345"),
                Arguments.of("User3", "12345")
        );
    }

}


The following code will do these steps:

1. Navigate to https://example.testproject.io/
2. Enter the username
3. Enter the password
4. Click on login button
5. Verify that the greetings title is the expected title

It will run 3 iterations with different login credentials in each iteration.
Any of these iterations comes from the following `@MethodSource`:

```java
private static Stream<Arguments> provideStringsForIsBlank() {
    return Stream.of(
            Arguments.of("User1", "12345"),
            Arguments.of("User2", "12345"),
            Arguments.of("User3", "12345")
    );
}
```
