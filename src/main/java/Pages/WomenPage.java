package pages;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WomenPage extends Helper {
    public WomenPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]") public WebElement toolbarProducts;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]") public WebElement productPositionItemOne;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]") public WebElement productPriceItemOne;


    @FindBy(id = "sorter") public WebElement selectorSortBy;
    @FindBy(id = "limiter") public WebElement selectorShowPage;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[4]/a") public WebElement orderIconButton;


}
