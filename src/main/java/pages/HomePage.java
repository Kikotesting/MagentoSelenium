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

    // MESSAGES Subscriptions
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div") WebElement messageForSubscription;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div") WebElement messageForAdded;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]") WebElement searchNoResultMessage;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/dl/dt") WebElement relatedSearchTerms;

    // IMAGES BANNERS
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/a/img") public WebElement newLumaYogaBanner;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/a/span") public WebElement getNewLumaYogaContent;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[3]/img") public WebElement lumaTakeItFromErin;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[1]/img") public WebElement lumaPantsBanner;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[1]/span") public WebElement lumaPantsContent;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[2]") public WebElement lumaTeesBanner;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[5]") public WebElement lumaTwiceAround;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[2]/span[2]") public WebElement lumaTeesContent;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[4]") public WebElement lumaPerformanceBanner;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[4]/span") public WebElement lumaPerformanceContent;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol") public WebElement hotSellersItems;
    @FindBy(xpath = "/html/body/div[2]/div[2]/p[1]") public WebElement lastParagraphFooter;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[1]")
    public WebElement oliviaLightJacket;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[2]") public WebElement sidebarLeftMenu;




    // Click methods
    public void clickHeaderSignInButton() {
        signInButton.isDisplayed();
        signInButton.click();
    }

    public void clickHeaderDropdownAccountButton() {
        dropdownAccBtn.isDisplayed();
        waitToBeVisible(dropdownAccBtn, 5);
        dropdownAccBtn.click();
    }

    public void clickHeaderDropdownMyAccount() {
        dropdownMyAccount.isDisplayed();
        waitToBeVisible(dropdownMyAccount, 5);
        dropdownMyAccount.click();
    }

    public void clickDropdownSignOut() {
        dropdownSignOut.isDisplayed();
        dropdownSignOut.click();
    }

    public void clickFooterSubscribeButton() {
        footerSubscribeBtn.isDisplayed();
        footerSubscribeBtn.click();
    }


}
