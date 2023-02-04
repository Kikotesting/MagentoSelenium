package pages;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends Helper {
    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // TEXT INFORMATION

    public WebElement getRegisterNewAccountMessage() {
        return registerNewAccountMessage;
    }

    public WebElement getContactInformationText() {
        return contactInformationText;
    }

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div") WebElement registerNewAccountMessage;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/p") WebElement contactInformationText;


}
