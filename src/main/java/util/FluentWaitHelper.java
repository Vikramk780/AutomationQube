package util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class FluentWaitHelper {

    WebDriver driver;

    public FluentWaitHelper(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForThisElement(By ele) {
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(ele));

        return driver.findElement(ele);
    }

}
