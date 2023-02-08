package ItemsPage;

import helpers.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemsPage extends PageHelper {
    public ItemsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public WebElement getItemOne() {
        return itemOne;
    }

    public WebElement getItemTwelve() {
        return itemTwelve;
    }

    public WebElement getItemTen() {
        return itemTen;
    }

    public WebElement getItemTwo() {
        return itemTwo;
    }
    public WebElement getItemThree() {
        return itemThree;
    }
    public WebElement getItemFour() {
        return itemFour;
    }

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/strong/a") WebElement itemOne;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[2]/div/div/strong/a") WebElement itemTwo;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[3]/div/div/strong/a") WebElement itemThree;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[4]/div/div/strong/a") WebElement itemFour;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[10]/div/div/strong/a") WebElement itemTen;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[12]/div/div/strong/a") WebElement itemTwelve;


}
