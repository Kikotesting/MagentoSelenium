package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Helper {
    public WebDriver driver;

    public Helper(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickElement(WebElement element){
        waitToBeVisible(element,5);
        element.isDisplayed();
        element.click();
    }

    public void pauseSeconds(Integer seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //Wait elements
    public void waitToBeVisible(WebElement element, int seconds) {
        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
    }
    public void waitToBeInvisible(WebElement element, int seconds) {
        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(element)));
    }
    public void waitToBeClickable(WebElement element, int seconds) {
        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(element))
        );
    }
        public void waitForInvisibilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
        wait.pollingEvery(Duration.ofMillis(1000));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    //GET INFORMATION
    public String getTitle() {
        return driver.getTitle();


    }
    /*    public void getListElements(WebElement element){
    //        List<WebElement> links = element.findElements(By.tagName("li"));
    //        for (int i = 0; i < links.size(); i++){
    //            Highlighter.highlightElement(driver,links.get(i));
    //        }
    */
    public void clickOptionFromList(WebElement element, String option) {
        List<WebElement> links = element.findElements(By.tagName("i"));
        for (int i = 0; i < links.size(); i++) {
            if (links.get(i).getText().equals(option)) {
                System.out.println(links.get(i).getText());
                links.get(i).click();
            }
        }
    }
    public void getOptionFromList(WebElement element, String option) {
        List<WebElement> links = element.findElements(By.tagName("a"));
        for (int i = 0; i < links.size(); i++) {
            if (links.get(i).getText().equals(option)) {
                System.out.println(links.get(i).getText());
            }
        }
    }
    public List<WebElement> getItems(List<WebElement> elements){
        return elements;
    }

    //SCROLLING
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public void scrollToPixels(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,arguments[0])", pixels);
    }
    public void scrollEndPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    //SELECTING
    private Select selectElement(WebElement element) {
        return new Select(element);
    }

    public void selectByVisibleTextElement(WebElement element, String valueText) {
        element.click();
        selectElement(element).selectByVisibleText(valueText);
    }
    public void selectByValueElement(WebElement element, String value) {
        selectElement(element).selectByValue(value);
    }
    public void selectByIndexElement(WebElement element, int index) {
        selectElement(element).selectByIndex(index);
    }


    //HOVERING
    public void hoverElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }
    public void hoverElementClick(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).click().perform();
    }

    //Input Fields
    public void setTextToField(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }
}