package helpers;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

//    public void clickOptionFromList(WebElement element, String option) {
//        List<WebElement> links = element.findElements(By.tagName("i"));
//        for (int i = 0; i < links.size(); i++) {
//            if (links.get(i).getText().equals(option)) {
//                System.out.println(links.get(i).getText());
//                links.get(i).click();
//            }
//        }
//    }
//    public void getOptionFromList(WebElement element, String option) {
//        List<WebElement> links = element.findElements(By.tagName("a"));
//        for (int i = 0; i < links.size(); i++) {
//            if (links.get(i).getText().equals(option)) {
//                System.out.println(links.get(i).getText());
//            }
//        }
//    }
//    public List<WebElement> getItems(List<WebElement> elements){
//        return elements;
//    }

}