package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public WebDriver driver;
    public LoginPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "email") WebElement emailField;
    @FindBy(id = "pass") WebElement passwordField;
    @FindBy(id = "send2") WebElement signInButton;
    @FindBy(xpath = "//*[@id=\"email-error\"]") public WebElement emailRequired;
    @FindBy(xpath = "//*[@id=\"pass-error\"]") public WebElement passwordRequired;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div") public WebElement errorMessage;
    public void enterValidEmail(){
        emailField.isDisplayed();
        emailField.sendKeys("mislead4@mail.bg");
    }
    public void enterValidPassword(){
        passwordField.isDisplayed();
        passwordField.sendKeys("Kiko123@");
    }
    public void enterInvalidEmail(){
        emailField.isDisplayed();
        emailField.sendKeys("penk9@mail.bg");
    }
    public void enterInvalidPassword(){
        passwordField.isDisplayed();
        passwordField.sendKeys("-1-20201-20");
    }
    public void enterEmptyEmail(){
        emailField.isDisplayed();
        emailField.sendKeys("");
    }
    public void enterEmptyPassword(){
        passwordField.isDisplayed();
        passwordField.sendKeys("");
    }
    public void clickSignInButton(){
        signInButton.isDisplayed();
        signInButton.click();
    }


}
