//import io.testproject.sdk.drivers.web.ChromeDriver;
//import io.testproject.sdk.interfaces.parameterization.TestProjectParameterizer;
//import io.testproject.sdk.internal.exceptions.AgentConnectException;
//import io.testproject.sdk.internal.exceptions.InvalidTokenException;
//import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ArgumentsSource;
//import org.openqa.selenium.By;

import java.io.IOException;


public class ParameterizedTestExample {

//    private ChromeDriver driver;
//
//    @BeforeEach
//    public void setup() throws InvalidTokenException, AgentConnectException, ObsoleteVersionException, IOException {
//        driver = new ChromeDriver();
//    }
//
//    @AfterEach
//    public void teardown() {
//        driver.quit();
//    }
//
//    @ParameterizedTest
//    @ArgumentsSource(TestProjectParameterizer.class)
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

}
