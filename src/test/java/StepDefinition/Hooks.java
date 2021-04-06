package StepDefinition;

import Utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static Utils.BrowserUtils.takeScreenshot;

public class Hooks {
    WebDriver driver = Driver.getDriver();

    @Before
    public void setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            takeScreenshot(driver, "test");
        }
        driver.close();
    }
}