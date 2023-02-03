//package helper;
//
//import com.beust.jcommander.internal.Nullable;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//import java.util.function.Function;
//
//public class WaitStrategy {
////    public WebDriver driver;
////
////    public WaitStrategy(WebDriver driver) {
////        this.driver = driver;
////        PageFactory.initElements(driver, this);
////    }
////
////    // VISIBILITY
////    public void waitForVisibilityOf(By locator, int timeOutInSeconds) {
////        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
////        wait.pollingEvery(Duration.ofMillis(100));
////        wait.until(ExpectedConditions.refreshed(
////                ExpectedConditions.visibilityOfElementLocated(locator))
////        );
////    }
////    public void waitForVisibilityOf(WebElement element, int timeOutInSeconds) {
////        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
////        wait.pollingEvery(Duration.ofMillis(100));
////        wait.until(ExpectedConditions.refreshed(
////                ExpectedConditions.visibilityOf(element))
////        );
////    }
////    public void waitForVisibilityOf(WebElement element) {
////        waitForVisibilityOf(element, 90);
////    }
////    // TEXT
////    public void waitText(String textToBeDisplayed, int timeOutInSecond) {
////        waitForVisibilityOf(By.xpath("//*[@text='" + textToBeDisplayed + "']"), timeOutInSecond);
////    }
//public void waitText(String textToBeDisplayed) {
//        waitForVisibilityOf(By.xpath("//*[@text='" + textToBeDisplayed + "']"));
//        }
//
//public void waitText(String textToBeDisplayed, int timeOutInSecond) {
//        waitForVisibilityOf(By.xpath("//*[@text='" + textToBeDisplayed + "']"), timeOutInSecond);
//        }
////
////    public void waitUntilElementGetsEnabled(WebElement element) {
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
////        wait.pollingEvery(Duration.ofMillis(100));
////        wait.until((ExpectedCondition<Boolean>) driver -> {
////            String enabled = element.getAttribute("enabled");
////            return "true".equals(enabled);
////        });
////    }
////
////    public void waitForClicabilityOf(WebElement element, int timeOutInSeconds) {
////        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
////        wait.pollingEvery(Duration.ofMillis(100));
////        wait.until(ExpectedConditions.refreshed(
////                ExpectedConditions.elementToBeClickable(element))
////        );
////    }
////
////    /**
////     * Wait until text disappear from screen
////     * Useful for loading dialogs
////     *
////     * @param text text which is expected to disappear
////     */
////    public void waitUntilTextDisappear(final String text) {
////        WebDriverWait wait = new WebDriverWait(driver, 90);
////        wait.pollingEvery(Duration.ofMillis(1000));
////        wait.until(new Function<WebDriver, Boolean>() {
////            public Boolean apply(@Nullable WebDriver webDriver) {
////                return !containsText(text);
////            }
////        });
////    }
////
////    public void waitUntilTextDisappear(final String text, int timeOutInSeconds) {
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
////        wait.pollingEvery(Duration.ofMillis(1000));
////        wait.until(new Function<WebDriver, Boolean>() {
////            @Nullable
////            public Boolean apply(@Nullable WebDriver webDriver) {
//                return !containsText(text);
//            }
//        });
//    }
//    /**
//     * Wait until text in element is equal to text param
//     *
//     * @param text    expected text
//     * @param element element to check
//     */
//    public void waitUntilTextEquals(final String text, final WebElement element) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
//        wait.pollingEvery(Duration.ofMillis(100));
//        wait.until(new Function<WebDriver, Object>() {
//            public Object apply(@Nullable WebDriver webDriver) {
//                return !element.getText().equals(text);
//            }
//        });
//    }
//    public void waitForInvisibilityOf(By locator) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
//        wait.pollingEvery(Duration.ofMillis(1000));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
//    }
//    public void waitForInvisibilityOf(String text, int timeOutInSeconds) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
//        wait.pollingEvery(Duration.ofMillis(1000));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='" + text + "']")));
//    }
//    public void waitForInvisibilityOf(By locator, int timeOutInSeconds) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
//        wait.pollingEvery(Duration.ofMillis(1000));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
//    }
//    public void waitForInvisibilityOfText(String text, int timeOutInSeconds) {
//        waitForInvisibilityOf(By.xpath("//*[@text='" + text + "']"), timeOutInSeconds);
//    }
//    public void waitForInvisibilityOf(WebElement element) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
//        wait.pollingEvery(Duration.ofMillis(1000));
//        wait.until(ExpectedConditions.invisibilityOf(element));
//    }
//    public void waitForInvisibilityOf(WebElement element, int timeOutInSeconds) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
//        wait.pollingEvery(Duration.ofMillis(1000));
//        wait.until(ExpectedConditions.invisibilityOf(element));
//    }
//
//}
