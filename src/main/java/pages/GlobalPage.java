package pages;

import helpers.PageHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlobalPage extends PageHelper {
    public GlobalPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public WebElement getMenuWomenTops() {
        return menuWomenTops;
    }

    public WebElement getMenuWomenTopsJackets() {
        return menuWomenTopsJackets;
    }

    public WebElement getMenuWhatsNew() {
        return menuWhatsNew;
    }

    public WebElement getMenuWomen() {
        return menuWomen;
    }

    public WebElement getMenuMen() {
        return menuMen;
    }

    public WebElement getMenuGear() {
        return menuGear;
    }

    public WebElement getMenuGearBags() {
        return menuGearBags;
    }

    public WebElement getMenuTraining() {
        return menuTraining;
    }

    public WebElement getMenuSale() {
        return menuSale;
    }

    public WebElement getSearchInputField() {
        return searchInputField;
    }

    public WebElement getNewsLetterField() {
        return newsLetterField;
    }

    public WebElement getSignInTextButton() {
        return signInTextButton;
    }

    public WebElement getCreateAccountTextButton() {
        return createAccountTextButton;
    }

    public WebElement getSubscribeButton() {
        return subscribeButton;
    }

    public WebElement getFooterAboutUsLink() {
        return footerAboutUsLink;
    }

    public WebElement getFooterCustomerServiceLink() {
        return footerCustomerServiceLink;
    }

    public WebElement getFooterPrivacyLink() {
        return footerPrivacyLink;
    }

    public WebElement getFooterAdvancedSearchLink() {
        return footerAdvancedSearchLink;
    }

    public WebElement getFooterOrdersReturnsLink() {
        return footerOrdersReturnsLink;
    }

    public WebElement getMessageSubscription() {
        return messageSubscription;
    }



    // MAIN MENU

    @FindBy(xpath = "//*[@id=\"ui-id-3\"]/span") WebElement menuWhatsNew;
    @FindBy(xpath = "//*[@id=\"ui-id-4\"]/span[2]") WebElement menuWomen;
    @FindBy(xpath = "//*[@id=\"ui-id-9\"]/span[2]") WebElement menuWomenTops;
    @FindBy(xpath = "//*[@id=\"ui-id-11\"]/span") WebElement menuWomenTopsJackets;
    @FindBy(xpath = "//*[@id=\"ui-id-5\"]/span[2]") WebElement menuMen;
    @FindBy(xpath = "//*[@id=\"ui-id-6\"]/span[2]") WebElement menuGear;
    @FindBy(xpath = "//*[@id=\"ui-id-25\"]/span") WebElement menuGearBags;
    @FindBy(xpath = "//*[@id=\"ui-id-7\"]/span[2]") WebElement menuTraining;
    @FindBy(xpath = "//*[@id=\"ui-id-8\"]/span") WebElement menuSale;

    // INPUT FIELDS
    @FindBy(className = "input-text") WebElement searchInputField;
    @FindBy(id = "newsletter") WebElement newsLetterField;

    // BUTTONS
    @FindBy(xpath = "//div[2]/header/div[1]/div/ul/li[2]/a") WebElement signInTextButton;
    @FindBy(xpath = "//div[2]/header/div[1]/div/ul/li[3]/a") WebElement createAccountTextButton;
    @FindBy(xpath = "//*[@id=\"newsletter-validate-detail\"]/div[2]/button") WebElement subscribeButton;

    // FOOTER
    @FindBy(xpath = "//footer/div/div[2]/div/ul/li[2]/a") WebElement footerAboutUsLink;
    @FindBy(xpath = "//footer/div/div[2]/div/ul/li[3]/a") WebElement footerCustomerServiceLink;
    @FindBy(xpath = "//footer/div/ul/li[2]/a") WebElement footerPrivacyLink;
    @FindBy(xpath = "//footer/div/ul/li[3]/a") WebElement footerAdvancedSearchLink;
    @FindBy(xpath = "/html/body/div[2]/footer/div/ul/li[4]/a") WebElement footerOrdersReturnsLink;

    // MESSAGES
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div") WebElement messageSubscription;
    @FindBy(xpath = "/html/body/div[2]/footer/div/div[2]/div/ul") WebElement footerLinks;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div") WebElement aboutUsPageText;

    public WebElement getAboutUsPageText() {
        return aboutUsPageText;
    }

    public WebElement getFooterLinks() {
        return footerLinks;
    }
}
