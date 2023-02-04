package pages;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignOutPage extends Helper {
    public SignOutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getSignOutMessageHeader() {
        return signOutMessageHeader;
    }

    public WebElement getSignOutMessageParagraph() {
        return signOutMessageParagraph;
    }

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/h1/span") WebElement signOutMessageHeader;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/p") WebElement signOutMessageParagraph;


}
