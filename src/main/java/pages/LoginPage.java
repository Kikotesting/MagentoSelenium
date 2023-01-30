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
    @FindBy(xpath = "//*[@id=\"email-error\"]")
    public WebElement emailRequired;
    @FindBy(xpath = "//*[@id=\"pass-error\"]")
    public WebElement passwordRequired;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")
    public WebElement errorMessage;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/h1/span")
    public WebElement signOutMessageHeader;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/p")
    public WebElement signOutMessageParagraph;
    @FindBy(id = "email")
    WebElement emailField;
    @FindBy(id = "pass")
    WebElement passwordField;
    @FindBy(id = "send2")
    WebElement signInButton;

    // Typing methods

    public void defaultLogin(){
        homePage = new HomePage(driver);
        homePage.signIn_Btn.click();
        enterValidEmail();
        enterValidPassword();
        clickSignInButton();
    }
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
        emailField.sendKeys("penk9@mail.bg");
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

    public void clickSignInButton() {
        signInButton.isDisplayed();
        signInButton.click();
    }


}
