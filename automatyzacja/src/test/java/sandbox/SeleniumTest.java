package sandbox;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.By.*;

public class SeleniumTest
{
    private WebDriver driver;

    @BeforeEach
    void setup()
    {
        //System.setProperty("webdriver.chrome.driver", "C:\WebDrivers\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    void canOpenGooglePage()
    {
        driver.get("https://google.com");
        WebElement searchbar;
        searchbar = driver.findElement(name("q"));
        searchbar.sendKeys("Rafał Markowicz blog");
        searchbar.submit();

        List<WebElement> results = driver
                .findElements(className("rc"))
                .stream()
                .filter(res -> res.findElement(By.cssSelector(".rc .r > a")).getAttribute("href").equals("https://markowicz.pro/"))
                .collect(Collectors.toList());

        Assertions.assertEquals(1, results.size());

        String resultTitle = results.get(0).findElement(By.tagName("h3")).getText();
        Assertions.assertEquals("Rafał Markowicz – Kolejny piękny dzień", resultTitle);

        String resultDisplayLink = results.get(0).findElement(By.tagName("cite")).getText();
        Assertions.assertEquals("http://markowicz.pro", resultDisplayLink);

    }

    @AfterEach
    void tearDown()
    {
        driver.quit();
    }
}

