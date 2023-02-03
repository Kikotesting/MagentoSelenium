package pages;

import helper.Helper;
import utils.FakeData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends Helper {
    public CreateAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    FakeData fakeData;
    // PERSONAL INFORMATION
    @FindBy(id = "firstname") WebElement firstnameField;
    @FindBy(id = "lastname") WebElement lastnameField;
    // SIGN IN INFORMATION
    @FindBy(id = "email_address") WebElement emailAddress;
    @FindBy(id = "password") WebElement password;
    @FindBy(id = "password-confirmation") WebElement passwordConfirmation;
    @FindBy(xpath = "//button/span[contains(text(),\"Create an Account\")]") WebElement createAccountButton;


    private void typeFirstnameAndLastName() {
        fakeData = new FakeData();

        firstnameField.isDisplayed();
        firstnameField.sendKeys(fakeData.firstname);
        lastnameField.isDisplayed();
        lastnameField.sendKeys(fakeData.lastname);
    }

    private void typeEmail() {
        emailAddress.isDisplayed();
        emailAddress.sendKeys(fakeData.emailAddress);
        String savedEmail = fakeData.emailAddress;
        System.out.println(savedEmail);
    }

    private void typePassword() {
        password.isDisplayed();
        password.sendKeys("Kiko123@");
    }

    private void typeConfirmPassword() {
        passwordConfirmation.isDisplayed();
        passwordConfirmation.sendKeys("Kiko123@");
    }

    private void clickCreateAccountButton() {
        createAccountButton.isDisplayed();
        createAccountButton.click();
    }

    public void registerNewUser() {
        typeFirstnameAndLastName();
        typeEmail();
        typePassword();
        typeConfirmPassword();
        clickCreateAccountButton();
    }


}
