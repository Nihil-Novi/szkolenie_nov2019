
package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WpNotePage extends WpPage {
    public static final By LOCATOR_COMMENT_FORM = By.id("commentform");

    public WpNotePage(WebDriver driver) {
        super(driver);
    }

    public boolean commentsAreAllowed() {
        waitForElement(LOCATOR_COMMENT_FORM);
        return driver.findElements(LOCATOR_COMMENT_FORM).size() == 1;
    }

    public WpNotePage publishComment(String comment, String author, String email) {
        WebElement commentField = driver.findElement(By.id("comment"));
        commentField.click();
        commentField.sendKeys(comment);

        WebElement authorField = driver.findElement(By.id("author"));
        authorField.click();
        authorField.sendKeys(author);

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.click();
        emailField.sendKeys(email);

        driver.findElement(By.id("submit")).click();
        driver.navigate().refresh();

        return new WpNotePage(driver);
    }

    public boolean hasComment(String comment, String author) {
        driver.get(driver.getCurrentUrl());

        // Assertions.assertTrue(driver.findElement(By.cssSelector()));

        List<WebElement> enteredComments = driver.findElements(By.cssSelector("p"));
        int howManyComments = enteredComments.size() - 1;
        for (int x = 0; x  <= howManyComments; x++)
        {
            String check = enteredComments.get(x).toString();
            if (comment.equals(check))
            {
                return true;
            }
        }
        return true;
    }
}