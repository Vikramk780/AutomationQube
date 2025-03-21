package stepDefinitions;

import Factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.pages.AddressBookEntriesPage;
import org.pages.HomePageObject;
import org.testng.Assert;

import java.sql.Driver;

public class AddressBookEntriesPageSteps {
   private WebDriver driver;
   private HomePageObject homePageObject;
   private AddressBookEntriesPage addressBookEntriesPage;

    public AddressBookEntriesPageSteps(){

        this.driver=DriverFactory.getDriver();
        this.homePageObject = new HomePageObject(driver);
    }



    @Given("I navigate to the Address Book Entries page")
    public void i_navigate_to_the_address_book_entries_page() {
        addressBookEntriesPage= homePageObject.clickOnAddressBookPage();

    }

    @When("I verify that the Address Book Entries page opens successfully")
    public void i_verify_that_the_address_book_entries_page_opens_successfully() {
        String actualAddressUrl="account/address";
        Assert.assertTrue(addressBookEntriesPage.checkAddressBookEntriesPageIsDisplayed().contains(actualAddressUrl),"Address book url not found");
    }

    @Then("I create a new address and confirm its successful creation")
    public void i_create_a_new_address_and_confirm_its_successful_creation() {
        addressBookEntriesPage.clickOnAddressBookPage();
          addressBookEntriesPage.cretaeNewAddress();
    }
}


