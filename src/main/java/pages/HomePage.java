package pages;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Helper {
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    // WELCOME TEXT
    @FindBy(xpath = "//header/div[1]/div/ul/li[1]/span")
    public WebElement welcomeUser;
    // MAIN MENU
    @FindBy(xpath = "//*[@id=\"ui-id-3\"]/span")
    public WebElement menuWhatsNew;
    @FindBy(xpath = "//*[@id=\"page-title-heading\"]/span")
    public WebElement whatsNewHeader;
    @FindBy(xpath = "/html/body/div[2]/div[2]")
    public WebElement breadcrumbs;
    @FindBy(xpath = "//*[@id=\"ui-id-4\"]/span[2]") public WebElement menuWomen;
    @FindBy(xpath = "//*[@id=\"ui-id-9\"]/span[2]") public WebElement menuWomen_Tops;
    @FindBy(xpath = "/html/body/div[2]/div[2]/ul/li[3]/strong") public WebElement breadcrumbs_Women_Tops;
    @FindBy(xpath = "//*[@id=\"ui-id-5\"]/span[2]")
    public WebElement menuMen;
    @FindBy(xpath = "//*[@id=\"ui-id-6\"]/span[2]")
    public WebElement menuGear;
    @FindBy(xpath = "//*[@id=\"ui-id-7\"]/span[2]")
    public WebElement menuTraining;
    @FindBy(xpath = "//*[@id=\"ui-id-8\"]/span")
    public WebElement menuSale;
    // FIELDS
    @FindBy(className = "input-text")
    public WebElement searchInputField;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]")
    public WebElement searchNoResultMessage;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/dl/dt")
    public WebElement relatedSearchTerms;
    @FindBy(id = "newsletter")
    public WebElement newsLetterField;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")
    public WebElement messageForSubscription;
    // BUTTONS
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[3]/a")
    public WebElement createAccBtn;
    @FindBy(className = ".showcart")
    public WebElement showCartIconBtn;
    // IMAGES BANNERS
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/a/img")
    public WebElement newLumaYogaBanner;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/a/span")
    public WebElement getNewLumaYogaContent;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[3]/img")
    public WebElement lumaTakeItFromErin;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[1]/img")
    public WebElement lumaPantsBanner;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[1]/span")
    public WebElement lumaPantsContent;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[2]")
    public WebElement lumaTeesBanner;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[5]")
    public WebElement lumaTwiceAround;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[2]/span[2]")
    public WebElement lumaTeesContent;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[4]")
    public WebElement lumaPerformanceBanner;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[4]/span")
    public WebElement lumaPerformanceContent;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol")
    public WebElement hotSellersItems;
    @FindBy(xpath = "/html/body/div[2]/div[2]/p[1]")
    public WebElement lastParagraphFooter;
    // FOOTER LINKS
    @FindBy(xpath = "//footer/div/div[2]/div/ul/li[2]/a")
    public WebElement footerAboutUsLink;
    @FindBy(xpath = "//footer/div/div[2]/div/ul/li[3]/a")
    public WebElement footerCustomerServiceLink;
    @FindBy(xpath = "//footer/div/ul/li[2]/a")
    public WebElement footerPrivacyLink;
    @FindBy(xpath = "//footer/div/ul/li[3]/a")
    public WebElement footerAdvancedSearchLink;
    @FindBy(xpath = "/html/body/div[2]/footer/div/ul/li[4]/a")
    public WebElement footerOrdersReturnsLink;
    @FindBy(xpath = "//button/span[contains(text(),\"Subscribe\")]")
    WebElement footerSubscribeBtn;
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/a")
    WebElement signIn_Btn;
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")
    WebElement dropdownAccBtn;
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a")
    WebElement dropdown_MyAccount;
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")
    WebElement dropdown_SignOut;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[1]")
    public WebElement oliviaLightJacket;

    // Click methods
    public void clickHeaderSignInButton() {
        signIn_Btn.isDisplayed();
        signIn_Btn.click();
    }

    public void clickHeaderDropdownAccountButton() {
        dropdownAccBtn.isDisplayed();
        waitToBeVisible(dropdownAccBtn, 5);
        dropdownAccBtn.click();
    }

    public void clickHeaderDropdownMyAccount() {
        dropdown_MyAccount.isDisplayed();
        waitToBeVisible(dropdown_MyAccount, 5);
        dropdown_MyAccount.click();
    }

    public void clickDropdownSignOut() {
        dropdown_SignOut.isDisplayed();
        dropdown_SignOut.click();
    }

    public void clickFooterSubscribeButton() {
        footerSubscribeBtn.isDisplayed();
        footerSubscribeBtn.click();
    }


}
