package itemsUtils;

import helpers.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemsSearchPage extends PageHelper {
    public ItemsSearchPage(WebDriver driver) {
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

    public WebElement getAddToCartButtonItemFour() {
        return addToCartButtonItemFour;
    }

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div") WebElement messageForAddingItemToCartContainer;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/div/strong/a") WebElement itemOne;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/div/div[4]/div/div[1]/form/button") WebElement addToCartButtonItemOne;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[2]/div/div/strong/a") WebElement itemTwo;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[2]/div/div/div[4]/div/div[1]/form/button") WebElement addToCartButtonItemTwo;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[3]/div/div/strong/a") WebElement itemThree;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[3]/div/div/div[4]/div/div[1]/form/button") WebElement addToCartButtonItemThree;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[4]/div/div/strong/a") WebElement itemFour;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[4]/div/div/div[4]/div/div[1]/form/button") WebElement addToCartButtonItemFour;


}
