package pages;

import helpers.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends PageHelper {
    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // TEXT INFORMATION

    public WebElement getRegisterNewAccountMessage() {
        return registerNewAccountMessage;
    }

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div") WebElement registerNewAccountMessage;


}
