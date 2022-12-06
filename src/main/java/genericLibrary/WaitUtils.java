package genericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class WaitUtils extends BaseClass {
    public WaitUtils() throws IOException {
    }

    public static void waitForPageToLoad()
    {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }
    public static void waitForElementClickable(WebDriver driver, WebElement element, long timeoutSec){
        new WebDriverWait(driver,Duration.ofSeconds(timeoutSec)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForCompleteElementToLoad( WebElement element, long timeoutSec) throws InterruptedException {
        int waitCount=0;

        while (waitCount<=timeoutSec){
            Thread.sleep(3000);
            if(element.isDisplayed())
                return;
            waitCount++;
        }
    }

    public static void waitForInterClickElementToLoad( WebElement element, long timeoutSec) throws InterruptedException {
        int waitCount=0;

        while (waitCount<=timeoutSec){
            Thread.sleep(6000);
            if(element.isDisplayed())
                return;
            waitCount++;
        }
    }
}
