package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;

public class WpMainPage extends WpPage{
    public static final By LOCATOR_POST_LINK = By.cssSelector("article.post .entry-title > a");

    public WpMainPage(WebDriver driver) {
        super(driver);
        driver.get("http://www.automation.markowicz.pro");
        waitForElement(By.cssSelector("body.home"));
    }

    public static WpMainPage open(WebDriver driver) {
        return new WpMainPage(driver);
    }

    public WpNotePage openLatestNote() {
       waitForElement(LOCATOR_POST_LINK).click();
        return new WpNotePage(driver);
    }

    public WpMainPage logInToWordpress()
    {
        WebElement logInButton = driver.findElement(By.linkText("Log in"));
        logInButton.click();


        driver.switchTo().activeElement().sendKeys("jan-automatyczny", Keys.TAB);
        driver.switchTo().activeElement().sendKeys("C0d3$pr1nt3r$");

        return new WpMainPage(driver);
    }
}
