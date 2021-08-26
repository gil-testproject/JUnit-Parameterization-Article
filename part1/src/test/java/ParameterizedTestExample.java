import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.stream.Stream;

public class ParameterizedTestExample {

    ChromeDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @ParameterizedTest
    @DisplayName("Login Test")
    @MethodSource("provideLoginCredentials")
    public void loginTest(String username, String password) {

        // Navigate to TestProject Example website
        driver.navigate().to("https://example.testproject.io/web/");

        // Login using provided credentials
        driver.findElement(By.cssSelector("#name")).sendKeys(username);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.cssSelector("#login")).click();

        // Validate successful login
        WebElement logoutButton = driver.findElement(By.cssSelector("#logout"));
        Assertions.assertTrue(logoutButton.isDisplayed(), "Login failed! ");

    }

    private static Stream<Arguments> provideLoginCredentials() {
        return Stream.of(
                Arguments.of("User1", "12345"), // Valid login
                Arguments.of("User2", "123456") // Invalid login
        );
    }

}

