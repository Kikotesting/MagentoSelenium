package pages;

import helpers.PageHelper;
import org.apache.commons.lang3.RandomStringUtils;
import faker.FakeData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateAccountPage extends PageHelper {
    public CreateAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    FakeData fakeData;
    final private String immutablePassword = "Kiko123@";
    private String randomPassword = RandomStringUtils.randomAlphabetic(5);
    private String passwordWeakOneChar = RandomStringUtils.randomAlphabetic(1).toLowerCase();
    private String passwordWeakThreeCharsLower = RandomStringUtils.randomAlphabetic(3).toLowerCase();
    private String passwordWeakThreeCharsUpper = RandomStringUtils.randomAlphabetic(3).toUpperCase();
    private String passwordOneDigit = RandomStringUtils.randomNumeric(1);
    private String passwordTwoDigits = RandomStringUtils.randomNumeric(2);
    private String passwordThreeDigits = RandomStringUtils.randomNumeric(3);
    private String passwordTenDigits = RandomStringUtils.randomNumeric(10);
    private String passwordAlphaNumeric = RandomStringUtils.randomAlphanumeric(25);

    public WebElement getFirstnameField() {
        return firstnameField;
    }
    public void setFirstname() {
        fakeData = new FakeData();
        getFirstnameField().isDisplayed();
        getFirstnameField().clear();
        getFirstnameField().sendKeys(fakeData.firstname);
    }
    public void setEmptyFirstname() {
        getFirstnameField().isDisplayed();
        getFirstnameField().clear();
        getFirstnameField().sendKeys("");
    }
    public WebElement getLastnameField() {
        return lastnameField;
    }
    public void setLastname() {
        fakeData = new FakeData();
        getLastnameField().isDisplayed();
        getLastnameField().clear();
        getLastnameField().sendKeys(fakeData.lastname);
    }
    public void setEmptyLastname() {
        getLastnameField().isDisplayed();
        getLastnameField().clear();
        getLastnameField().sendKeys("");
    }
    public WebElement getEmailAddressField() {
        return emailAddressField;
    }
    public void setEmailAddress() {
        fakeData = new FakeData();
        getEmailAddressField().isDisplayed();
        getEmailAddressField().clear();
        getEmailAddressField().sendKeys(fakeData.emailAddress);
        String saveNewEmail = fakeData.emailAddress;
        System.out.println(saveNewEmail);
    }
    public void setEmptyEmailAddress() {
        getEmailAddressField().isDisplayed();
        getEmailAddressField().clear();
        getEmailAddressField().sendKeys("");
    }
    public WebElement getPasswordField() {
        return passwordField;
    }
    private void setDefaultPassword() {
        getPasswordField().isDisplayed();
        getPasswordField().clear();
        getPasswordField().sendKeys(immutablePassword);
    }
    public void setRandomPassword() {
        getPasswordField().isDisplayed();
        getPasswordField().clear();
        getPasswordField().sendKeys(randomPassword);
    }
    public void setEmptyPassword() {
        getPasswordField().isDisplayed();
        getPasswordField().clear();
        getPasswordField().sendKeys("");
    }
    public void setWeakPasswordOneChar() {
        getPasswordField().isDisplayed();
        getPasswordField().clear();
        getPasswordField().sendKeys(passwordWeakOneChar);
        System.out.println(passwordWeakOneChar);
    }
    public void setWeakPasswordThreeCharsLower() {
        getPasswordField().isDisplayed();
        getPasswordField().clear();
        getPasswordField().sendKeys(passwordWeakThreeCharsLower);
        System.out.println(passwordWeakThreeCharsLower);
    }
    public void setWeakPasswordLowerAndUpperCharsWithoutDigit() {
        getPasswordField().isDisplayed();
        getPasswordField().clear();
        String lowerUpperChars = passwordWeakThreeCharsLower.concat(passwordWeakThreeCharsUpper);
        getPasswordField().sendKeys(lowerUpperChars);
        System.out.println(lowerUpperChars);
    }
    public void setWeakPasswordTenDigitsWithoutChars() {
        getPasswordField().isDisplayed();
        getPasswordField().clear();
        getPasswordField().sendKeys(passwordTenDigits);
        System.out.println(passwordTenDigits);
    }
    public void setMediumPasswordCharsAndTwoDigits() {
        getPasswordField().isDisplayed();
        getPasswordField().clear();
        String mixCharsTwoDigits = passwordWeakThreeCharsUpper.concat(passwordWeakThreeCharsLower).concat(passwordTwoDigits);
        getPasswordField().sendKeys(mixCharsTwoDigits);
        System.out.println(mixCharsTwoDigits);
    }
    public void setStrongPasswordLowerAndUpperCharsAndThreeDigits() {
        getPasswordField().isDisplayed();
        getPasswordField().clear();
        String mixCharsAndThreeDigit = passwordWeakThreeCharsUpper.concat(passwordWeakThreeCharsLower).concat(passwordThreeDigits);
        getPasswordField().sendKeys(mixCharsAndThreeDigit);
        System.out.println(mixCharsAndThreeDigit);
    }
    public void setVeryStrongPasswordLowerAndUpperCharsMoreDigitsAndSymbol() {
        getPasswordField().isDisplayed();
        getPasswordField().clear();
        getPasswordField().sendKeys(passwordAlphaNumeric);
        System.out.println(passwordAlphaNumeric);
    }

    public WebElement getPasswordConfirmationField() {
        return passwordConfirmationField;
    }
    public void setDefaultPasswordConfirmation() {
        getPasswordConfirmationField().isDisplayed();
        getPasswordConfirmationField().clear();
        getPasswordConfirmationField().sendKeys(immutablePassword);
    }
    public void setRandomPasswordConfirmation() {
        getPasswordConfirmationField().isDisplayed();
        getPasswordConfirmationField().clear();
        getPasswordConfirmationField().sendKeys(randomPassword);
    }
    public void setEmptyConfirmationPassword() {
        getPasswordConfirmationField().isDisplayed();
        getPasswordConfirmationField().clear();
        getPasswordConfirmationField().sendKeys("");
    }
    public WebElement getCreateAccountButton() {
        return createAccountButton;
    }

    public WebElement getCheckBoxIsSubscribed() {
        return checkBoxIsSubscribed;
    }
    public void clickCheckedBox(){
        if(!getCheckBoxIsSubscribed().isSelected())
            getCheckBoxIsSubscribed().click();
    }
    public void setNewAccountInformation() {
        setFirstname();
        setLastname();
        setEmailAddress();
        setDefaultPassword();
        setDefaultPasswordConfirmation();
    }


    public WebElement getCreateAccountHeaderText() {
        return createAccountHeaderText;
    }
    public WebElement getCreateAccountPersonalInfoText() {
        return createAccountPersonalInfoText;
    }
    public WebElement getCreateAccountSignInInfoText() {
        return createAccountSignInInfoText;
    }
    public WebElement getFirstnameRequired() {
        return firstnameRequired;
    }
    public WebElement getLastnameRequired() {
        return lastnameRequired;
    }
    public WebElement getEmailAddressRequired() {
        return emailAddressRequired;
    }

    public WebElement getPasswordRequired() {
        return passwordRequired;
    }
    public WebElement getPasswordConfirmationRequired() {
        return passwordConfirmationRequired;
    }
    public WebElement getPasswordStrength() {
        return passwordStrength;
    }



    @FindBy(xpath = "//*[@id=\"form-validate\"]/fieldset[1]/legend/span") WebElement createAccountPersonalInfoText;
    @FindBy(xpath = "//*[@id=\"form-validate\"]/fieldset[2]/legend/span") WebElement createAccountSignInInfoText;
    // PERSONAL INFORMATION
    @FindBy(id = "firstname") WebElement firstnameField;
    @FindBy(xpath = "//*[@id=\"firstname-error\"]") WebElement firstnameRequired;
    @FindBy(id = "lastname") WebElement lastnameField;
    @FindBy(xpath = "//*[@id=\"lastname-error\"]") WebElement lastnameRequired;
    // SIGN IN INFORMATION
    @FindBy(id = "email_address") WebElement emailAddressField;
    @FindBy(xpath = "//*[@id=\"email_address-error\"]") WebElement emailAddressRequired;
    @FindBy(id = "password") WebElement passwordField;
    @FindBy(xpath = "//*[@id=\"password-error\"]") WebElement passwordRequired;
    @FindBy(xpath = "//*[@id=\"password-strength-meter\"]") WebElement passwordStrength;
    @FindBy(id = "password-confirmation") WebElement passwordConfirmationField;
    @FindBy(xpath = "//*[@id=\"password-confirmation-error\"]") WebElement passwordConfirmationRequired;
    @FindBy(xpath = "//*[@id=\"is_subscribed\"]") WebElement checkBoxIsSubscribed;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/h1/span") WebElement createAccountHeaderText;
    @FindBy(xpath = "//button/span[contains(text(),\"Create an Account\")]") WebElement createAccountButton;
}
