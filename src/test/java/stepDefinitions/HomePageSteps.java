package stepDefinitions;

import Factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.pages.EditAccountPageObject;
import org.pages.HomePageObject;
import org.pages.LoginPageObject;
import org.testng.Assert;


import java.util.List;
import java.util.Map;
import java.util.Properties;

public class HomePageSteps {

    private HomePageObject homePageObject;
    private WebDriver driver=DriverFactory.getDriver();
    private Properties prop= ApplicationHooks.getProperties();
    private EditAccountPageObject editAccountPageObject;
    private LoginPageObject loginPageObject = new LoginPageObject(driver);




    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(io.cucumber.datatable.DataTable dataTable) {

        driver.get(prop.getProperty("url"));
        List<Map<String, String>> credList = dataTable.asMaps();
        String userName = credList.get(0).get("username");
        String password = credList.get(0).get("password");

        homePageObject = loginPageObject.doLogin(userName, password);
    }


    @When("I click on the desktop button")
    public void i_click_on_the_desktop_button() throws InterruptedException {
        homePageObject.clickOnDesktopbutton();
        Thread.sleep(5000);

    }

    @Then("I should be redirected to the desktop page")
    public void i_should_be_redirected_to_the_desktop_page() {
        System.out.println("hello");

    }




    public EditAccountPageObject geteditAccountPageObject(){

        return editAccountPageObject;
    }
}
