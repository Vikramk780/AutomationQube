package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.FluentWaitHelper;

public class EditAccountPageObject {
    WebDriver driver;
    FluentWaitHelper fluentWaitHelper;

    private By firstnamefield = By.xpath("//input[@id='input-firstname']");
    private By continueBtn = By.xpath("//input[@type='submit']");


    public EditAccountPageObject(WebDriver driver) {

        this.driver = driver;
        fluentWaitHelper = new FluentWaitHelper(driver);
    }

    public void editfirstName() throws InterruptedException {
        Thread.sleep(2000);
        fluentWaitHelper.waitForThisElement(firstnamefield).clear();
        Thread.sleep(2000);
        fluentWaitHelper.waitForThisElement(firstnamefield).sendKeys("vikrama");

    }

    public void clickOnContinue() throws InterruptedException {
        Thread.sleep(1000);
        fluentWaitHelper.waitForThisElement(continueBtn).click();
        Thread.sleep(1000);
    }

    public void revertFirstName() throws InterruptedException {
        Thread.sleep(2000);
        fluentWaitHelper.waitForThisElement(firstnamefield).clear();
        Thread.sleep(2000);
        fluentWaitHelper.waitForThisElement(firstnamefield).sendKeys("vikram");

    }


    public String checkEditPageIsDisplayed() {

        return driver.getCurrentUrl();
    }

}
