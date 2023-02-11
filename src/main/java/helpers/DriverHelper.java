package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverHelper {
    public WebDriver driver;
    public DriverHelper(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void highLightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: gray; border: 2px solid red;');", element);
    }
    //HOVERING
    public void hoverElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }
    public void hoverElementClick(WebElement element) {
        Actions action = new Actions(driver);
        highLightElement(element);
        action.moveToElement(element).click().perform();
    }

    // WAITS
    public void waitToBeVisible(WebElement element, int seconds) {
        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
    }
    public void waitForTextUpdated(WebElement element, int seconds, String text) {
        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.pollingEvery(Duration.ofSeconds(1));
        // wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
        highLightElement(element);
        wait.until(ExpectedConditions.textToBePresentInElement(element,text));
    }
    public void waitToBeInvisible(WebElement element, int seconds) {
        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.pollingEvery(Duration.ofMillis(1000));
        highLightElement(element);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(element)));
    }
    public void waitToBeClickable(WebElement element, int timeOutInSeconds) {
        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.pollingEvery(Duration.ofMillis(100));
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(element))
        );
        highLightElement(element);
    }
    public void waitForInvisibilityOfTextInDom(String text, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.pollingEvery(Duration.ofMillis(1000));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='" + text + "']")));
    }
    public void waitForInvisibilityOfByLocator(By locator, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.pollingEvery(Duration.ofMillis(1000));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public void waitUntilElementGetsEnabled(WebElement element, Integer seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until((ExpectedCondition<Boolean>) driver -> {
            String enabled = element.getAttribute("enabled");
            return "true".equals(enabled);
        });
    }
    public void waitForVisibilityOf(String text, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.pollingEvery(Duration.ofMillis(1000));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@text='" + text + "']")));
    }
    public void waitText(String textToBeDisplayed, int timeOutInSecond) {
        waitForVisibilityOf(textToBeDisplayed,timeOutInSecond);
    }



    //SELECTING
    private Select selectElement(WebElement element) {
        return new Select(element);
    }
    public void selectByVisibleTextElement(WebElement element, String valueText) {
        highLightElement(element);
        element.click();
        selectElement(element).selectByVisibleText(valueText);
    }
    public void selectByValueElement(WebElement element, String value) {
        highLightElement(element);
        selectElement(element).selectByValue(value);
    }
    public void selectByIndexElement(WebElement element, int index) {
        highLightElement(element);
        selectElement(element).selectByIndex(index);
    }

    //SCROLLING
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        highLightElement(element);
    }
    public void scrollToPixels(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,arguments[0])", pixels);
    }
    public void scrollEndPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }




}
