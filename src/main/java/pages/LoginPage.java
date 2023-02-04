package pages;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Helper {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    // Get elements
    public WebElement getEmailField() {
        return emailField;
    }
    public WebElement getPasswordField() {
        return passwordField;
    }
    public WebElement getSignInButton() {
        return signInButton;
    }
    public WebElement getCreateAccountButton() {
        return createAccountButton;
    }
    public WebElement getEmailRequired() {
        return emailRequired;
    }
    public WebElement getPasswordRequired() {
        return passwordRequired;
    }

    public WebElement getWelcomeDefaultMessage() {
        return welcomeDefaultMessage;
    }

    public WebElement getWelcomeLoggedInMessage() {
        return welcomeLoggedInMessage;
    }

    public WebElement getSignInIncorrectMessage() {
        return signInIncorrectMessage;
    }

    public void defaultLogin(){
       setValidEmail();
       setValidPassword();
       clickSignInButton();
    }

    public void setValidEmail() {
        getEmailRequired().isDisplayed();
        getEmailRequired().sendKeys("mislead4@mail.bg");
    }
    public void setValidPassword() {
        getPasswordField().isDisplayed();
        getPasswordField().sendKeys("Kiko123@");
    }
    public void setInvalidEmail() {
        getEmailField().isDisplayed();
        getEmailField().sendKeys("929838");
    }
    public void setWrongEmail() {
        getEmailField().isDisplayed();
        getEmailField().sendKeys("milioannannko@mail.bg");
    }
    public void setInvalidPassword() {
        getPasswordField().isDisplayed();
        getPasswordField().sendKeys(" " +6+" ");
    }
    public void setWrongPassword() {
        getPasswordField().isDisplayed();
        getPasswordField().sendKeys("Blagodarya");
    }
    public void setEmptyEmail() {
        getEmailField().isDisplayed();
        getEmailField().sendKeys("");
    }
    public void setEmptyPassword() {
        getPasswordField().isDisplayed();
        getPasswordField().sendKeys("");
    }
    // CLICK methods
    public void clickSignInButton() {
        getSignInButton().isDisplayed();
        getSignInButton().click();
    }
    public void clickCreateAccountButton() {
        getCreateAccountButton().isDisplayed();
        getCreateAccountButton().click();
    }

    // FIELDS
    @FindBy(id = "email") WebElement emailField;
    @FindBy(id = "pass") WebElement passwordField;
    // BUTTONS
    @FindBy(id = "send2") WebElement signInButton;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[2]/div[2]/div/div/a") WebElement createAccountButton;
    // MESSAGES
    @FindBy(xpath = "//*[@class=\"not-logged-in\"]") WebElement welcomeDefaultMessage;
    @FindBy(xpath = "//*[@class=\"logged-in\"]") WebElement welcomeLoggedInMessage;
    // REQUIRED Validation
    @FindBy(xpath = "//*[@id=\"email-error\"]") WebElement emailRequired;
    @FindBy(xpath = "//*[@id=\"pass-error\"]") WebElement passwordRequired;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div") WebElement signInIncorrectMessage;



}
