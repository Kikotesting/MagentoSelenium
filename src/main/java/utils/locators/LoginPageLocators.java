package utils.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocators {

    @FindBy(id = "#email") public WebElement emailField;
    @FindBy(id = "#pass") public WebElement passwordField;
    @FindBy(id = "#send2") public WebElement submitBtn;

}
