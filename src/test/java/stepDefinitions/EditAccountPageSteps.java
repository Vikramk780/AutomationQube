package stepDefinitions;

import Factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.pages.EditAccountPageObject;
import org.pages.HomePageObject;
import org.testng.Assert;

public class EditAccountPageSteps {
    WebDriver driver;
    private HomePageObject homePageObject;
    private EditAccountPageObject editAccountPageObject;

    @Given("i visit editaccounts by clicking on editaccounts link on homepage")
    public void i_visit_editaccounts_by_clicking_on_editaccounts_link_on_homepage() {
        homePageObject = new HomePageObject(DriverFactory.getDriver());
        editAccountPageObject=homePageObject.clickOnEditAccountsLink();
    }

    @When("i verify the pag is editaccounts page")
    public void i_verify_the_pag_is_editaccounts_page() {
        String actualurl="account/edit";
        Assert.assertTrue(editAccountPageObject.checkEditPageIsDisplayed().contains(actualurl), "Edit Account page not opened!");

    }

    @When("i enter new name in firstname field")
    public void i_enter_new_name_in_firstname_field() throws InterruptedException {
        //homePageSteps= new HomePageSteps();
       // editAccountPageObject= homePageSteps.geteditAccountPageObject();
        editAccountPageObject.editfirstName();
    }

    @Then("i click on continue button")
    public void i_click_on_continue_button() throws InterruptedException {
        editAccountPageObject.clickOnContinue();

    }

    @When("i enter old name in firstname field")
    public void i_enter_old_name_in_firstname_field() throws InterruptedException {
        editAccountPageObject.revertFirstName();
    }


}
