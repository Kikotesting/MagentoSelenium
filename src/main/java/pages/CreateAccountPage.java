package pages;

import helper.Helper;
import randomData.FakeData;
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
    final private String immutablePassword = "Kiko123@";
    public WebElement getCreateAccountHeaderText() {
        return createAccountHeaderText;
    }
    private WebElement getFirstnameField() {
        return firstnameField;
    }
    private void setFirstname() {
        fakeData = new FakeData();
        getFirstnameField().isDisplayed();
        getFirstnameField().clear();
        getFirstnameField().sendKeys(fakeData.firstname);
    }
    private WebElement getLastnameField() {
        return lastnameField;
    }
    private void setLastname() {
        fakeData = new FakeData();
        getLastnameField().isDisplayed();
        getLastnameField().clear();
        getLastnameField().sendKeys(fakeData.lastname);
    }
    private WebElement getEmailAddressField() {
        return emailAddressField;
    }
    private void setEmailAddress() {
        fakeData = new FakeData();
        getEmailAddressField().isDisplayed();
        getEmailAddressField().clear();
        getEmailAddressField().sendKeys(fakeData.emailAddress);
        String saveNewEmail = fakeData.emailAddress;
        System.out.println(saveNewEmail);
    }
    private WebElement getPasswordField() {
        return passwordField;
    }
    private void setPassword() {
        getPasswordField().isDisplayed();
        getPasswordField().clear();
        getPasswordField().sendKeys(immutablePassword);
    }
    private WebElement getPasswordConfirmationField() {
        return passwordConfirmationField;
    }
    private void setPasswordConfirmation() {
        getPasswordConfirmationField().isDisplayed();
        getPasswordConfirmationField().clear();
        getPasswordConfirmationField().sendKeys(immutablePassword);
    }
    public WebElement getCreateAccountButton() {
        return createAccountButton;
    }
    public WebElement getCreateAccountPersonalInfoText() {
        return createAccountPersonalInfoText;
    }
    public WebElement getCreateAccountSignInInfoText() {
        return createAccountSignInInfoText;
    }
    public WebElement getCheckBoxIsSubscribed() {
        return checkBoxIsSubscribed;
    }
    public void isCheckedBox(){
        if(!getCheckBoxIsSubscribed().isSelected())
            getCheckBoxIsSubscribed().click();
    }
    public void setNewAccountInformation() {
        setFirstname();
        setLastname();
        setEmailAddress();
        setPassword();
        setPasswordConfirmation();
    }
    @FindBy(xpath = "//*[@id=\"form-validate\"]/fieldset[1]/legend/span") WebElement createAccountPersonalInfoText;
    @FindBy(xpath = "//*[@id=\"form-validate\"]/fieldset[2]/legend/span") WebElement createAccountSignInInfoText;
    // PERSONAL INFORMATION
    @FindBy(id = "firstname") WebElement firstnameField;
    @FindBy(id = "lastname") WebElement lastnameField;
    // SIGN IN INFORMATION
    @FindBy(id = "email_address") WebElement emailAddressField;
    @FindBy(id = "password") WebElement passwordField;
    @FindBy(id = "password-confirmation") WebElement passwordConfirmationField;
    @FindBy(xpath = "//*[@id=\"is_subscribed\"]") WebElement checkBoxIsSubscribed;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/h1/span") WebElement createAccountHeaderText;
    @FindBy(xpath = "//button/span[contains(text(),\"Create an Account\")]") WebElement createAccountButton;
}
