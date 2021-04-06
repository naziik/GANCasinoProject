package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BrowserUtils {

    public static void selectByText(WebElement element, String selectText) {
        Select select = new Select(element);
        select.selectByValue(selectText);
    }

    public static WebElement waitUntilElementToBeClickable(WebDriver driver, int timeInSec, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSec);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void takeScreenshot(WebDriver driver, String testCaseName) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        long timestamp = System.currentTimeMillis();
        File destinationDir = new File("screenshot/" + testCaseName + "_" + timestamp + ".png");
        FileUtils.copyFile(file, destinationDir);
    }
}
