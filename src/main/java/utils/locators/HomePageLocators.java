package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageLocators {
    public WebDriver driver;
    public HomePageLocators(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // Main Menus
    @FindBy(xpath = "//*[@id=\"ui-id-3\"]/span") public WebElement menuWhatsNew;
    @FindBy(xpath = "//*[@id=\"page-title-heading\"]/span") public WebElement whatsNewHeader;
    @FindBy(xpath = "/html/body/div[2]/div[2]") public WebElement breadcrumbs;
    @FindBy(xpath = "//*[@id=\"ui-id-4\"]/span[2]") public WebElement menuWomen;
    @FindBy(xpath = "//*[@id=\"ui-id-5\"]/span[2]") public WebElement menuMen;
    @FindBy(xpath = "//*[@id=\"ui-id-6\"]/span[2]")public WebElement menuGear;
    @FindBy(xpath = "//*[@id=\"ui-id-7\"]/span[2]")public  WebElement menuTraining;
    @FindBy(xpath = "//*[@id=\"ui-id-8\"]/span") public  WebElement menuSale;

    // Footer Links
    @FindBy(xpath = "//footer/div/div[2]/div/ul/li[2]/a") public WebElement footerAboutUsLink;
    @FindBy(xpath = "//footer/div/div[2]/div/ul/li[3]/a") public WebElement footerCustomerServiceLink;
    @FindBy(xpath = "//footer/div/ul/li[2]/a") public WebElement footerPrivacyLink;
    @FindBy(xpath = "//footer/div/ul/li[3]/a") public WebElement footerAdvancedSearchLink;
    @FindBy(xpath = "/html/body/div[2]/footer/div/ul/li[4]/a") public WebElement footerOrdersReturnsLink;

    // Fields
    @FindBy(id = "#search") WebElement searchInputField;
    @FindBy(id = "#newsletter") WebElement newsLetterField;

    // Buttons
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[3]/a") WebElement createAccBtn;
    @FindBy(className = ".showcart") WebElement showCartIconBtn;
    @FindBy(xpath = "//button/span[contains(text(),\"Subscribe\")]") WebElement footerSubscribeBtn;
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/a") WebElement signIn_Btn;

    // Images Banners

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/a/img") WebElement newLumaYoga;
}
