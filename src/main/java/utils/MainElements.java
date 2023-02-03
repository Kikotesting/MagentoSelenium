package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class MainElements {
    // MAIN MENU
    @FindBy(xpath = "//*[@id=\"ui-id-9\"]/span[2]") WebElement menuWomenTops;
    @FindBy(xpath = "//*[@id=\"ui-id-3\"]/span") WebElement menuWhatsNew;
    @FindBy(xpath = "//*[@id=\"ui-id-4\"]/span[2]") WebElement menuWomen;
    @FindBy(xpath = "//*[@id=\"ui-id-5\"]/span[2]") WebElement menuMen;
    @FindBy(xpath = "//*[@id=\"ui-id-6\"]/span[2]") WebElement menuGear;
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

}
