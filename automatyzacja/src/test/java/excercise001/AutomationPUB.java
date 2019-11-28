package excercise001;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationPUB
{
   private WebDriver driver;

    @BeforeEach
    void setup() {

   driver = new ChromeDriver();
   driver.get("https://automationpub.com/");
    }
    //verify title matches

    @Test
    void checkTitle() {
        WebElement button = driver.findElement(By.xpath("//button[contains(.,'webdriver')]"));
        WebElement readmore = driver.findElement(By.cssSelector("a._self.pt-cv-readmore.btn.btn-success"));
        readmore.click();
        WebElement header = driver.findElement(By.cssSelector("h1.entry-title"));
        Assertions.assertEquals("001 SELENIUM – WEBDRIVER", header);
    }

    @AfterEach

    void tearDown()
    {
        driver.quit();
    }
}
