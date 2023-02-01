package pages;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LumaYogaPage extends Helper {

    public LumaYogaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[2]/div/div/div[4]/div/div[1]/form/button/span")
    public WebElement addToCart;



    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[2]") public WebElement gwenShortItem;

    @FindBy(xpath = "//*[@id=\"mini-cart\"]/li/div/div/strong/a") public WebElement gwenCartNameItem;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[3]") public WebElement fionnaShortItem;
    @FindBy(xpath = "//*[@id=\"mini-cart\"]/li[1]/div/div/strong/a") public WebElement fionnaCartNameItem;
}
