package Pages;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    public RegistrationPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@class='newUser green']")
    public WebElement joinNowButton;

    @FindBy(xpath ="//select[@id='title']")
    public WebElement title;

    @FindBy(xpath = "//input[@id='forename']")
    public WebElement firstname;

    @FindBy(xpath = "//input[@name='map(lastName)']")
    public WebElement surname;

    @FindBy(xpath = "//input[@name='map(terms)']")
    public WebElement checkboxTerms;

    @FindBy(xpath = "//input[@id='form']")
    public WebElement JoinNowReg;

    @FindBy(xpath = "//label[@for='dob']")
    public WebElement requiredTextUnderDOB;

}
