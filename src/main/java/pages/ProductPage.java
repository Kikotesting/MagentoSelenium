package pages;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Helper {
    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id=\"option-label-size-143-item-175\"]") public WebElement size32;
    @FindBy(xpath = "//*[@id=\"option-label-color-93-item-50\"]") public WebElement blueColor;
    @FindBy(xpath = "//*[@id=\"option-label-color-93-item-58\"]") public WebElement redColor;
    @FindBy(xpath = "//*[@id=\"product-addtocart-button\"]/span") public WebElement addToCartButton;
    @FindBy(xpath = "//*[@id=\"btn-minicart-close\"]") public WebElement closeCartButton;
    @FindBy(xpath = "//*[@id=\"minicart-content-wrapper\"]/div[2]/div[1]/span[1]") public WebElement counterItems;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div") public WebElement messageAddedToCart;
}
