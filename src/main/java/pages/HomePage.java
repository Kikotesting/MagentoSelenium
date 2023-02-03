package pages;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    // IMAGES BANNERS
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/a/img") WebElement newLumaYogaBanner;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/a/span") WebElement getNewLumaYogaContent;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[3]/img") WebElement lumaTakeItFromErin;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[1]/img") WebElement lumaPantsBanner;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[1]/span") WebElement lumaPantsContent;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[2]") WebElement lumaTeesBanner;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[5]") WebElement lumaTwiceAround;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[2]/span[2]") WebElement lumaTeesContent;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[4]") WebElement lumaPerformanceBanner;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/div/a[4]/span") WebElement lumaPerformanceContent;


}
