package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import util.FluentWaitHelper;
import util.FluentWaitHelperForMultiElement;

import java.util.List;

public class AddressBookEntriesPage {
    WebDriver driver;
    FluentWaitHelper fluentWaitHelper;
    FluentWaitHelperForMultiElement fluentWaitHelperForMultiElement;

    private By firstNameField = By.xpath("//input[@name='firstname']");
    private By lastNameField = By.xpath("//input[@name='lastname']");
    private By companyField = By.xpath("//input[@name='company']");
    private By address_1Field = By.xpath("//input[@name='address_1']");
    private By cityField = By.xpath("//input[@name='city']");
    private By inputcountrydrop = By.xpath("//select[@id='input-country']");
    private By inputcountry = By.xpath("(//option[contains(text(),'India')])[1]");

    private By inputzonedrop = By.xpath("//select[@id='input-zone']");
    private By inputstate = By.xpath("(//option[contains(text(),'Maharashtra')])[1]");

    private By submitbtn = By.xpath("//input[@type='submit']");
    private By createNewAddressbtn = By.xpath("//a[text()='New Address']");
    private By addDeletebtn = By.xpath("//a[text()='Delete']");

    public AddressBookEntriesPage(WebDriver driver) {
        this.driver = driver;
        fluentWaitHelper = new FluentWaitHelper(driver);
        fluentWaitHelperForMultiElement =new FluentWaitHelperForMultiElement(driver);
    }

    public void clickOnAddressBookPage() {
        fluentWaitHelper.waitForThisElement(createNewAddressbtn).click();

    }

    public String checkAddressBookEntriesPageIsDisplayed() {

        return driver.getCurrentUrl();
    }

    public void cretaeNewAddress() {

        fluentWaitHelper.waitForThisElement(firstNameField).sendKeys("adscbsadnc");
        fluentWaitHelper.waitForThisElement(lastNameField).sendKeys("dwefwf");
        fluentWaitHelper.waitForThisElement(companyField).sendKeys("fcwef");
        fluentWaitHelper.waitForThisElement(address_1Field).sendKeys("scsads");
        fluentWaitHelper.waitForThisElement(cityField).sendKeys("edfserwf");


        Select drop = new Select(fluentWaitHelper.waitForThisElement(inputcountrydrop));
        drop.selectByVisibleText("Afghanistan");


        Select drop1 = new Select(fluentWaitHelper.waitForThisElement(inputzonedrop));
        drop1.selectByVisibleText("Badakhshan");


        fluentWaitHelper.waitForThisElement(submitbtn).click();
    }

    public List<WebElement> getDeleteBtnCount(){

      return fluentWaitHelperForMultiElement.waitForThisElement(addDeletebtn);

    }

}
