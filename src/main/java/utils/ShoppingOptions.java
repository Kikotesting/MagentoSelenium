package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingOptions {

    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[1]") WebElement categoryOption;
    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[2]") WebElement styleOption;
    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[3]") WebElement sizeOption;
    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[4]") WebElement priceOption;
    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[5]") WebElement colorOption;
    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[6]") WebElement materialOption;
    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[7]") WebElement ecoCollectOption;
    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[8]") WebElement performanceOption;
    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[9]") WebElement erinRecommendsOption;
    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[10]") WebElement newOption;
    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[11]") WebElement saleOption;
    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[12]") WebElement patternOption;
    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[13]") WebElement climateOption;
}
