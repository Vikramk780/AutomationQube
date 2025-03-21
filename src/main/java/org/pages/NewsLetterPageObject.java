package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import util.FluentWaitHelper;

public class NewsLetterPageObject {
    FluentWaitHelper fluentWaitHelper;
    WebDriver driver;
    public NewsLetterPageObject(WebDriver driver){
        this.driver=driver;
        fluentWaitHelper = new FluentWaitHelper(driver);
    }


    private By radiobtn=By.xpath("(//input[@type='radio'])[1]");
    private By radiobtn2=By.xpath("(//input[@type='radio'])[1]");
    private By continuebtn= By.xpath("//input[@type='submit' and @value='Continue']\n");
    private By successmsg = By.xpath("//*[contains(text(),'Success: Your newsletter subscription has been successfully updated!')]\n");


    public void checkNewsSubscriptionRadioIsSelectedOrNot(){
        WebElement elet=fluentWaitHelper.waitForThisElement(radiobtn);

        if(elet.isSelected()){
            fluentWaitHelper.waitForThisElement(radiobtn2).click();
        }else{
            fluentWaitHelper.waitForThisElement(radiobtn).click();

        }
        fluentWaitHelper.waitForThisElement(continuebtn).click();
    }
    public String checkSuccessMsgAfterUpdateSubScription(){
        String textt=fluentWaitHelper.waitForThisElement(successmsg).getText();
        return textt;

    }
}
