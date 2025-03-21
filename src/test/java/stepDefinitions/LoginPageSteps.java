package stepDefinitions;

import Factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.HomePageObject;
import org.pages.LoginPageObject;
import org.testng.Assert;
import util.ConfigReader;

import java.io.IOException;
import java.util.Properties;


public class LoginPageSteps {

    private WebDriver driver;
    private LoginPageObject loginPageObject;
    private Properties prop;
    private HomePageObject homePageObject;


//    public LoginPageSteps(){
//
//        this.prop = ApplicationHooks.getProperties();
//    }


    @Given("I am on the OpenCart login page")
    public void i_am_on_the_open_cart_login_page() throws IOException {

        prop=ApplicationHooks.getProperties();
        driver=DriverFactory.getDriver();
        driver.get(prop.getProperty("url"));
        loginPageObject = new LoginPageObject(driver);

    }

    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
        loginPageObject.enterEmail("kvikramautomationtesting@gmail.com");
        loginPageObject.enterPassword("Test@1234");
    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {
        loginPageObject.enterEmail(username);
        loginPageObject.enterPassword(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button()
    {
        homePageObject= loginPageObject.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertEquals(loginPageObject.checkLogoutLink(), true);
    }



    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String errorMessage) {
        // Assert that an error message is displayed on the page matching the expected error message
        Assert.assertEquals( driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), true);
    }

    @When("I click on the \"Forgotten Password\" link")
    public void i_click_on_the_forgotten_password_link() {
        loginPageObject.clickForgottenPasswordLink();
    }

    @Then("I should be redirected to the password reset page")
    public void i_should_be_redirected_to_the_password_reset_page() {
        // Assert that the current URL contains the password reset page route
        Assert.assertTrue(loginPageObject.getForgotPwdPageUrl().contains("account/forgotten"));
    }

    //Getter method to pass home page object to homepage steps class
    public HomePageObject getHomepageObject(){
        return homePageObject;
    }
}