package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.FluentWaitHelper;

public class LoginPageObject {

    private WebDriver driver;
    FluentWaitHelper fluentWaitHelper;


    // Locators
    private By emailInputLocator = By.name("email");
    private By passwordInputLocator = By.name("password");
    private By loginButtonLocator = By.xpath("//input[@type='submit']");
    private By forgottenPasswordLinkLocator = By.linkText("Forgotten Password");
    private By logoutLinkLocator = By.linkText("Logout");


    // Constructor
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        fluentWaitHelper = new FluentWaitHelper(driver);
    }

    // Methods
    public void enterEmail(String email) {
        fluentWaitHelper.waitForThisElement(emailInputLocator).sendKeys(email);

    }

    public void enterPassword(String password) {
        fluentWaitHelper.waitForThisElement(passwordInputLocator).sendKeys(password);

    }

    public HomePageObject clickLoginButton() {
        fluentWaitHelper.waitForThisElement(loginButtonLocator).click();
        return new HomePageObject(driver);
    }

    public void clickForgottenPasswordLink() {
        fluentWaitHelper.waitForThisElement(forgottenPasswordLinkLocator).click();

    }

    public boolean checkForgotPwdLink() {
        return fluentWaitHelper.waitForThisElement(forgottenPasswordLinkLocator).isDisplayed();
    }

    public boolean checkLogoutLink() {
        return fluentWaitHelper.waitForThisElement(logoutLinkLocator).isDisplayed();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public String getForgotPwdPageUrl() {
        String forgotPwdPageUrl = driver.getCurrentUrl();
        return forgotPwdPageUrl;
    }

    public HomePageObject doLogin(String un, String pwd) {
        System.out.println("login with: " + un + " and " + pwd);
        fluentWaitHelper.waitForThisElement(emailInputLocator).sendKeys(un);
        fluentWaitHelper.waitForThisElement(passwordInputLocator).sendKeys(pwd);
        fluentWaitHelper.waitForThisElement(loginButtonLocator).click();
        return new HomePageObject(driver);
    }
}
