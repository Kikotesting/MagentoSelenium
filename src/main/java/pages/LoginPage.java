package pages;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Helper {
    HomePage homePage;
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    // Get elements
    public HomePage getHomePage() {
        return homePage;
    }
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
    public void defaultLogin(){
       enterValidEmail();
       enterValidPassword();
       clickSignInButton();
    }

    // FIELDS
    @FindBy(id = "email") WebElement emailField;
    @FindBy(id = "pass") WebElement passwordField;
    // BUTTONS
    @FindBy(id = "send2") WebElement signInButton;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[2]/div[2]/div/div/a") WebElement createAccountButton;
    @FindBy(xpath = "//*[@class=\"not-logged-in\"]") WebElement welcomeDefaultMessage;
    @FindBy(xpath = "//*[@class=\"logged-in\"]") WebElement welcomeLoggedInMessage;

    // REQUIRED MESSAGES
    @FindBy(xpath = "//*[@id=\"email-error\"]") WebElement emailRequired;
    @FindBy(xpath = "//*[@id=\"pass-error\"]") WebElement passwordRequired;

    // TYPING methods
    public void enterValidEmail() {
        emailField.isDisplayed();
        emailField.sendKeys("mislead4@mail.bg");
    }
    public void enterValidPassword() {
        passwordField.isDisplayed();
        passwordField.sendKeys("Kiko123@");
    }
    public void enterInvalidEmail() {
        emailField.isDisplayed();
        emailField.sendKeys("929838");
    }
    public void enterInvalidPassword() {
        passwordField.isDisplayed();
        passwordField.sendKeys("-1-20201-20");
    }
    public void enterEmptyEmail() {
        emailField.isDisplayed();
        emailField.sendKeys("");
    }
    public void enterEmptyPassword() {
        passwordField.isDisplayed();
        passwordField.sendKeys("");
    }
    // CLICK methods
    public void clickSignInButton() {
        signInButton.isDisplayed();
        signInButton.click();
    }



}
