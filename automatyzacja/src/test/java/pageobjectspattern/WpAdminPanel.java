package pageobjectspattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WpAdminPanel
{
    protected final WebDriver driver;

    public WpAdminPanel(WebDriver driver)
    {
        this.driver = driver;
    }

    protected static void hoverOverElement(WebElement element)
    {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public static WpAdminPanel logOut()
    {
        WebElement nameBar = driver.findElement(By.id("wpadminbar")).findElement(By.className("display-name"));

        hoverOverElement(nameBar);

        WebElement logOutButton = driver.findElement(By.linkText("Log Out"));
        logOutButton.click();


    }

}

