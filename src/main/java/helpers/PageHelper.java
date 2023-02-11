package helpers;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class PageHelper extends DriverHelper {
    WebDriver driver;
    public PageHelper(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void clickElement(WebElement element){
        waitToBeVisible(element,5);
        waitToBeClickable(element,5);
        element.click();
    }
    public void pauseSeconds(Integer seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void pressEnter(WebElement element){
        element.isDisplayed();
        element.sendKeys(Keys.ENTER);
    }
    public void setText(WebElement element, String message){
        waitToBeVisible(element,5);
        element.click();
        element.clear();
        element.sendKeys(message);
    }

}