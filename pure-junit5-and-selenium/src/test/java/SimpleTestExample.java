import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

// SimpleTestExample.java
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleTestExample {

    // SimpleTestExample.java
    @Test
    @DisplayName("Login Test")
    public void loginTest() {

        ChromeDriver driver = new ChromeDriver();

        // Navigate to TestProject Example website
        driver.navigate().to("https://example.testproject.io/web/");

        // Login using provided credentials
        driver.findElement(By.cssSelector("#name")).sendKeys("User1");
        driver.findElement(By.cssSelector("#password")).sendKeys("12345");
        driver.findElement(By.cssSelector("#login")).click();

        // Validate successful login
        WebElement logoutButton = driver.findElement(By.cssSelector("#logout"));
        Assertions.assertTrue(logoutButton.isDisplayed(), "Login failed! ");
        driver.quit();
    }
}
