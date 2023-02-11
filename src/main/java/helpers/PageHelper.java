package helpers;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
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
        highLightElement(element);
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
        waitToBeVisible(element,10);
        highLightElement(element);
        element.clear();
        element.sendKeys(message);
    }

}