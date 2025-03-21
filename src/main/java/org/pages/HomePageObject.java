package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.FluentWaitHelper;

public class HomePageObject {

    WebDriver driver;
    FluentWaitHelper fluentWaitHelper;

    private By desktopbtn = By.xpath("//a[@class='list-group-item' and contains(text(), 'Address Book')]");
    private By editaccountsLink = By.xpath("//a[contains(text(), 'Edit Account')]");
    private By addressbookpagebtn = By.xpath("//a[text()='Address Book']");
    private By newsletterbtn =By.xpath("(//a[contains(text(),'Newsletter')])[2]");

    public HomePageObject(WebDriver driver) {
        this.driver = driver;

        fluentWaitHelper = new FluentWaitHelper(driver);

    }

    public void clickOnDesktopbutton() throws InterruptedException {
        fluentWaitHelper.waitForThisElement(desktopbtn).click();


    }

    public EditAccountPageObject clickOnEditAccountsLink() {
        fluentWaitHelper.waitForThisElement(editaccountsLink).click();
        return new EditAccountPageObject(driver);
    }

    public AddressBookEntriesPage clickOnAddressBookPage() {
        fluentWaitHelper.waitForThisElement(addressbookpagebtn).click();
        return new AddressBookEntriesPage(driver);
    }

    public NewsLetterPageObject clickOnNewsletterbutton(){
        fluentWaitHelper.waitForThisElement(newsletterbtn).click();
        return new NewsLetterPageObject(driver);
    }
}
