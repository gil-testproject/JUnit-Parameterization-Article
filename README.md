
# Converting JUnit 5 & Selenium into TestProject coded test

## Introduction
In this article, I will explain how to convert the JUnit 5 parameterized test into a test that can be executed with the power of TestProject. This way, we will be able to use all of the good stuff that TestProject brings to us :)


## Why we need it?


### TestProject brings to us the following benefits

* No need to download chrome driver / mobile driver
* No need to set up reporting service
* No need to sync the tests with multiple tests machines (It is all on the cloud)
* Free support in our great community ( https://forum.testproject.io/ )
* Free add-ons (shared code that bundled as "Addons" and can be used in your tests)


### What you will learn

By the end of this guide you will able to turn this code:

```java
public class ParameterizedTestExample {

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    public void loginTest(String username, String password) {
        ...
        ...
    }

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                ...
                ...
        );
    }

}

```

Into something that can be shared, reused, adjusted, managed:
![image](https://user-images.githubusercontent.com/81077108/130460317-626b669b-ae10-434c-a71b-676d3c26f6e3.png)

All of the parameters part will be taken care by the system.

You will able to type the parameters of the method directly in the system:
![image](https://user-images.githubusercontent.com/81077108/130460580-3eddcede-bba7-400e-92b6-ce88547e1e22.png)

Once the test is converted to test bundle under the system, you will also be able to setup CSV without changing the code.
![image](https://user-images.githubusercontent.com/81077108/130460994-8141316d-235d-4bcc-95bd-b65dec66f9df.png)

`loginTestParameters.csv`:
```csv
password,username
12345,User1
12345,User2
12345,User3
```

Once you generated CSV and uploaded it, you will able to select it here:
![image](https://user-images.githubusercontent.com/81077108/130461283-8c66686a-b365-45e8-a33f-3d727f36f4a5.png)



## Let's get started!

For demonstration purposes only, we will use a very simple JUnit 5 & pure selenium project and we will learn how to take this existing project and turn it into a coded test that can be executed with the TestProject platform (Agent & Service).

Please clone the following simple project:

https://github.com/gil-testproject/JUnit-Parameterization-Article/tree/main/pure-junit5-and-selenium


### Pure JUnit 5 & Selenium test

Let’s have a look on the test class example in this project:

`src\test\java\ParameterizedTestExample.java`

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
```

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

Here is the final result:

![image](https://user-images.githubusercontent.com/81077108/130455076-485c8371-abd7-4822-89b9-e0b956f63864.png)


In addition, we also have the fllowing `build.gradle` file


