package stepDefinitions;

import Factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.AddressBookEntriesPage;
import org.pages.HomePageObject;
import org.testng.Assert;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class AddressBookEntriesPageSteps {
    private WebDriver driver;
    private HomePageObject homePageObject;
    private AddressBookEntriesPage addressBookEntriesPage;

    public AddressBookEntriesPageSteps() {

        this.driver = DriverFactory.getDriver();
        this.homePageObject = new HomePageObject(driver);
    }


    @Given("I navigate to the Address Book Entries page")
    public void i_navigate_to_the_address_book_entries_page() {
        addressBookEntriesPage = homePageObject.clickOnAddressBookPage();

    }

    @When("I verify that the Address Book Entries page opens successfully")
    public void i_verify_that_the_address_book_entries_page_opens_successfully() {
        String actualAddressUrl = "account/address";
        Assert.assertTrue(addressBookEntriesPage.checkAddressBookEntriesPageIsDisplayed().contains(actualAddressUrl), "Address book url not found");
    }

    @Then("I create a new address and confirm its successful creation")
    public void i_create_a_new_address_and_confirm_its_successful_creation() {
        addressBookEntriesPage.clickOnAddressBookPage();
        addressBookEntriesPage.cretaeNewAddress();
    }

    @Then("i delete all addresses present")
    public void i_delete_all_addresses_present() {


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            while (true) {
                // Re-fetch delete buttons to avoid stale elements
                List<WebElement> deleteButtons = addressBookEntriesPage.getDeleteBtnCount();

                if (deleteButtons.isEmpty()) {
                    System.out.println("✅ No more addresses left to delete.");
                    break; // Exit when all addresses are deleted
                }

                try {
                    // Click the first delete button
                    deleteButtons.get(0).click();

                    // Wait for alert and accept
                    wait.until(ExpectedConditions.alertIsPresent());
                    driver.switchTo().alert().accept();

                    // ✅ Wait for the page to refresh
                    Thread.sleep(2000);  // Small pause to allow DOM refresh (adjust if needed)

                    // ✅ Check if warning message appears
                    List<WebElement> warningMessage = driver.findElements(By.xpath("//*[contains(text(), 'Warning: You must have at least one address!')]"));
                    if (!warningMessage.isEmpty()) {
                        System.out.println("⚠ Warning message detected: Cannot delete the last address.");
                        break; // Stop deleting further
                    }

                    // ✅ Wait for the delete button to become stale
                    wait.until(ExpectedConditions.stalenessOf(deleteButtons.get(0)));

                } catch (StaleElementReferenceException e) {
                    System.out.println("⚠ Element became stale, retrying...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }







    }


