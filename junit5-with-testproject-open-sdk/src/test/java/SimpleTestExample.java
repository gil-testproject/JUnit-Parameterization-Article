import io.testproject.sdk.drivers.ReportingDriver;
import io.testproject.sdk.drivers.web.ChromeDriver;
import io.testproject.sdk.interfaces.junit5.ExceptionsReporter;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;


import java.io.IOException;

public class SimpleTestExample implements ExceptionsReporter {

    ChromeDriver driver;

    @BeforeEach
    public void setup() throws InvalidTokenException, AgentConnectException, ObsoleteVersionException, IOException {
        driver = new ChromeDriver("sd0_HkC9Hx5jZDdGbFbIwQ2cQ6la6QOrpyWeHMo4FIg1", new ChromeOptions());
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }


    // SimpleTestExample.java
    @Test
    @DisplayName("Login Test")
    public void loginTest() {

        // ChromeDriver driver = new ChromeDriver(); // Removed!

        // Navigate to TestProject Example website
        driver.navigate().to("https://example.testproject.io/web/");

        // Login using provided credentials
        driver.findElement(By.cssSelector("#name")).sendKeys("User1");
        driver.findElement(By.cssSelector("#password")).sendKeys("12345");
        driver.findElement(By.cssSelector("#login")).click();

        // Validate successful login
        WebElement logoutButton = driver.findElement(By.cssSelector("#logout"));
        Assertions.assertTrue(logoutButton.isDisplayed(), "Login failed! ");

        // driver.quit(); // Removed!
    }

    @Override
    public ReportingDriver getDriver() {
        return driver;
    }
}
