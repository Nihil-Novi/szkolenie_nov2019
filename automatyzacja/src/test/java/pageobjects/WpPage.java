package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WpPage
{
    protected final WebDriver driver;

    public WpPage(WebDriver driver) {
        this.driver = driver;
    }
    protected WebElement waitForElement(By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, 5);
       return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
