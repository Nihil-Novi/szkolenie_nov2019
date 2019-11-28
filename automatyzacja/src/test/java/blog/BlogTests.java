package blog;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.By.className;

public class BlogTests
    {
        private WebDriver driver;

        @BeforeEach
        void setup(){
            driver = new ChromeDriver();
            driver.get("https://markowicz.pro/");

            //System.setProperty("webdriver.chrome.driver", "C:\WebDrivers\chromedriver.exe");

        }

        @Test
        void countArticles()
        {
            List<WebElement> articles = driver.findElements(By.cssSelector("article"));
            int numberOf = articles.size();
            Assertions.assertEquals(10, numberOf);
        }

        @Test
        void findPageNumbers()
        {
            WebElement paginator = driver.findElement(By.className("page-numbers"));
            Assertions.assertEquals(true, paginator.isDisplayed());
        }

        @Test
        void checkPaginatorDirects()
        {
           WebElement page = driver.findElement(By.cssSelector("a.2.page-numbers"));
           page.click();
           String url = driver.getCurrentUrl();
           String check = "https://markowicz.pro/page/2/";
           Assertions.assertEquals(check, url);
        }

        @Test
        void checkArrowDirects()
        {
            WebElement page = driver.findElement(By.cssSelector("a.next.page-numbers"));
            page.click();
            String url = driver.getCurrentUrl();
            String check = "https://markowicz.pro/page/2/";
            Assertions.assertEquals(check, url);
        }


        @AfterEach
        void tearDown()
        {
            driver.quit();
        }
    }