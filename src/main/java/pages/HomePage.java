package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public WebDriver driver;
    public HomePage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    // WELCOME TEXT
    @FindBy(xpath = "//header/div[1]/div/ul/li[1]/span") public WebElement welcomeUser;

    // MAIN MENU
    @FindBy(xpath = "//*[@id=\"ui-id-3\"]/span") public WebElement menuWhatsNew;
    @FindBy(xpath = "//*[@id=\"page-title-heading\"]/span") public WebElement whatsNewHeader;
    @FindBy(xpath = "/html/body/div[2]/div[2]") public WebElement breadcrumbs;
    @FindBy(xpath = "//*[@id=\"ui-id-4\"]/span[2]") public WebElement menuWomen;
    @FindBy(xpath = "//*[@id=\"ui-id-5\"]/span[2]") public WebElement menuMen;
    @FindBy(xpath = "//*[@id=\"ui-id-6\"]/span[2]")public WebElement menuGear;
    @FindBy(xpath = "//*[@id=\"ui-id-7\"]/span[2]")public  WebElement menuTraining;
    @FindBy(xpath = "//*[@id=\"ui-id-8\"]/span") public  WebElement menuSale;


    // FIELDS
    @FindBy(id = "#search") public WebElement searchInputField;
    @FindBy(id = "#newsletter") public WebElement newsLetterField;

    // BUTTONS
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[3]/a") public WebElement createAccBtn;
    @FindBy(className = ".showcart") public WebElement showCartIconBtn;
    @FindBy(xpath = "//button/span[contains(text(),\"Subscribe\")]") public WebElement footerSubscribeBtn;
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/a") WebElement signIn_Btn;
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button") WebElement dropdownAccBtn;
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a") WebElement dropdown_MyAccount;
    public void clickHeaderSignInButton(){
        signIn_Btn.isDisplayed();
        signIn_Btn.click();
    }
    public void clickHeaderDropdownAccountButton(){
        dropdownAccBtn.isDisplayed();
        dropdownAccBtn.click();
    }
    public void clickHeaderDropdownMyAccount(){
        dropdown_MyAccount.isDisplayed();
        dropdown_MyAccount.click();
    }

    // IMAGES BANNERS
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/a/img") public WebElement newLumaYogaBanner;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/a/span") public WebElement getNewLumaYogaContent;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[1]/img") public WebElement lumaPantsBanner;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[1]/span") public WebElement lumaPantsContent;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[2]") public WebElement lumaTeesBanner;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[2]/span[2]") public WebElement lumaTeesContent;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[4]") public WebElement lumaPerformanceBanner;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[4]/span") public WebElement lumaPerformanceContent;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol") public WebElement hotSellersItems;


    // FOOTER LINKS
    @FindBy(xpath = "//footer/div/div[2]/div/ul/li[2]/a") public WebElement footerAboutUsLink;
    @FindBy(xpath = "//footer/div/div[2]/div/ul/li[3]/a") public WebElement footerCustomerServiceLink;
    @FindBy(xpath = "//footer/div/ul/li[2]/a") public WebElement footerPrivacyLink;
    @FindBy(xpath = "//footer/div/ul/li[3]/a") public WebElement footerAdvancedSearchLink;
    @FindBy(xpath = "/html/body/div[2]/footer/div/ul/li[4]/a") public WebElement footerOrdersReturnsLink;









}
