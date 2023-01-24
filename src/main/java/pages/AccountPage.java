package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    // Text Information
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[1]/h1/span") public WebElement myAccountTextHeader;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[1]/strong") public WebElement accountInfoText;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div[1]/strong/span") public WebElement accountContactInfoText;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div[2]/strong/span") public WebElement accountNewslettersText;
}
