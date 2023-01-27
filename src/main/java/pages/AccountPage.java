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

    // TEXT INFORMATION
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div") public WebElement registerNewAccountMessage;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[1]/h1/span") public WebElement myAccountTextHeader;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[1]/strong") public WebElement accountInfoText;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div[1]/strong/span") public WebElement accountContactInfoText;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div[2]/strong/span") public WebElement accountNewslettersText;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/p") public WebElement userNameInfo;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[4]/div[1]/strong") public WebElement addressBookInfo;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[4]/div[2]/div[1]/strong/span") public WebElement defaultBillingAddress;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[4]/div[2]/div[2]/strong/span") public WebElement defaultShippingAddress;
}
