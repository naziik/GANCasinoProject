package StepDefinition;

import Pages.RegistrationPage;
import Utils.BrowserUtils;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationPageTest {

    static WebDriver driver = Driver.getDriver();
    RegistrationPage registrationPage = new RegistrationPage(driver);

    @Given("user navigates to Gan home page")
    public void user_navigates_to_gan_home_page() {
        driver.get("https://moneygaming.qa.gameaccount.com/main.do");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @When("user click JOIN NOW button")
    public void user_click_join_now_button() {
        BrowserUtils.waitUntilElementToBeClickable(driver, 10, registrationPage.joinNowButton).click();
    }


    @When("user select {string} from dropDown")
    public void user_select_value_from_drop_down(String title) {
        BrowserUtils.selectByText(registrationPage.title, title);
    }


    @When("user enters its {string} and {string}")
    public void user_enters_its_first_name_and_last_name(String firstName, String surName) {
        registrationPage.firstname.sendKeys(firstName);
        registrationPage.surname.sendKeys(surName);
    }


    @When("user check the checkBox in I accept the Terms and Conditions and certify that I am over the age of 18")
    public void user_check_the_check_box() {
        registrationPage.checkboxTerms.click();
    }

    @Then("user submit by clicking JOIN NOW")
    public void user_submit_by_clicking_join_now() {
        registrationPage.JoinNowReg.click();
    }

    @Then("user validates message {string} under the date of birth box")
    public void user_validates_message_under_the_date_of_birth_box(String expectedTextUnderDOB) {
        String actualTextUnderDOB = registrationPage.requiredTextUnderDOB.getText();
        Assert.assertEquals("Required text under DOB does not match", expectedTextUnderDOB, actualTextUnderDOB);
    }

}
