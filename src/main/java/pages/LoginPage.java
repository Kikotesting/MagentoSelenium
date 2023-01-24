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
    public void enterValidEmail(){
        emailField.isDisplayed();
        emailField.sendKeys("mislead4@mail.bg");
    }
    public void enterValidPassword(){
        passwordField.isDisplayed();
        passwordField.sendKeys("Kiko123@");
    }
    public void clickSignInButton(){
        signInButton.isDisplayed();
        signInButton.click();
    }


}
