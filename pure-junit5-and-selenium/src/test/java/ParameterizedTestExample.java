import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
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

//    @ParameterizedTest
//    @MethodSource("provideStringsForIsBlank")
//    public void loginTest(String username, String password) {
//
//        // Navigate to TestProject Example website
//        driver.navigate().to("https://example.testproject.io/web/");
//
//        // Login using provided credentials
//        driver.findElement(By.cssSelector("#name")).sendKeys(username);
//        driver.findElement(By.cssSelector("#password")).sendKeys(password);
//        driver.findElement(By.cssSelector("#login")).click();
//
//        // Validate successful and correct login
//        String actual = driver.findElement(By.cssSelector("#greetings")).getText();
//        String expected = String.format("Hello %s, let's complete the test form:", username);
//        Assertions.assertEquals(expected, actual);
//    }
//
//
//    private static Stream<Arguments> provideStringsForIsBlank() {
//        return Stream.of(
//                Arguments.of("User1", "12345"),
//                Arguments.of("User2", "12345"),
//                Arguments.of("User3", "12345")
//        );
//    }

}
