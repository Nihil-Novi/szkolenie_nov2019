package pageobjectspattern;

import driverfactory.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTests {

    public WebDriver driver;

    @BeforeEach
    void setup()
    {
        driver = DriverFactory.getDriver();
    }

    @AfterEach
    void cleanup()
    {
        driver.quit();
    }

    WebDriver getBrowser()
    {
        return driver;
    }
}
