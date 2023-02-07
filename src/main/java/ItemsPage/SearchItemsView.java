package ItemsPage;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchItemsView extends Helper {
    public SearchItemsView(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getMessageForAddingItemToCartContainer() {
        return messageForAddingItemToCartContainer;
    }

    public WebElement getItemOne() {
        return itemOne;
    }

    public WebElement getAddToCartButtonItemOne() {
        return addToCartButtonItemOne;
    }

    public WebElement getItemTwo() {
        return itemTwo;
    }

    public WebElement getAddToCartButtonItemTwo() {
        return addToCartButtonItemTwo;
    }

    public WebElement getItemThree() {
        return itemThree;
    }

    public WebElement getAddToCartButtonItemThree() {
        return addToCartButtonItemThree;
    }

    public WebElement getItemFour() {
        return itemFour;
    }

    public WebElement getItemFive() {
        return itemFive;
    }

    public WebElement getItemSix() {
        return itemSix;
    }

    public WebElement getItemSeven() {
        return itemSeven;
    }

    public WebElement getItemEight() {
        return itemEight;
    }

    public WebElement getItemNine() {
        return itemNine;
    }

    public WebElement getItemTen() {
        return itemTen;
    }

    public WebElement getItemEleven() {
        return itemEleven;
    }

    public WebElement getItemTwelve() {
        return itemTwelve;
    }
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div") WebElement messageForAddingItemToCartContainer;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/div/strong/a") WebElement itemOne;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/div/div[4]/div/div[1]/form/button") WebElement addToCartButtonItemOne;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[2]/div/div/strong/a") WebElement itemTwo;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[2]/div/div/div[4]/div/div[1]/form/button") WebElement addToCartButtonItemTwo;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[3]/div/div/strong/a") WebElement itemThree;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[3]/div/div/div[4]/div/div[1]/form/button") WebElement addToCartButtonItemThree;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[4]/div/div/strong/a") WebElement itemFour;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[5]/div/div/strong/a") WebElement itemFive;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[6]/div/div/strong/a") WebElement itemSix;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[7]/div/div/strong/a") WebElement itemSeven;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[8]/div/div/strong/a") WebElement itemEight;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[9]/div/div/strong/a") WebElement itemNine;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[10]/div/div/strong/a") WebElement itemTen;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[11]/div/div/strong/a") WebElement itemEleven;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[12]/div/div/strong/a") WebElement itemTwelve;
}
