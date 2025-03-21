package stepDefinitions;

import Factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.pages.HomePageObject;
import org.pages.NewsLetterPageObject;
import org.testng.Assert;

public class NewsLetterPageSteps {
    WebDriver driver;
    NewsLetterPageObject newsLetterPageObject;
    HomePageObject homePageObject;

    public NewsLetterPageSteps() {
        this.driver = DriverFactory.getDriver();
       this.homePageObject = new HomePageObject(driver);

    }


    @Given("i visit newsletter page")
    public void i_visit_newsletter_page() {
        newsLetterPageObject = homePageObject.clickOnNewsletterbutton();
    }

    @When("i update the subscription")
    public void i_update_the_subscription() {
        newsLetterPageObject.checkNewsSubscriptionRadioIsSelectedOrNot();
    }

    @Then("i verify success msg after update of subscription")
    public void i_verify_success_msg_after_update_of_subscription() {
        String succesmsg = newsLetterPageObject.checkSuccessMsgAfterUpdateSubScription();
        Assert.assertEquals(succesmsg, "Success: Your newsletter subscription has been successfully updated!");
    }

}
