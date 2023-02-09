package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import reports.TakerPhoto;
import java.time.Duration;
public class BaseTest{
    public WebDriver driver;
    TakerPhoto listenerPhoto;
    @BeforeAll
    static void beforeAllTests() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void beforeEachTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-info-bars");
        options.addArguments("--disable-extensions");
        // options.addArguments("headless"); for invisible browser
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        final String baseUrl = "https://magento.softwaretestingboard.com/";
        driver.get(baseUrl);
    }
    @AfterEach
    void afterEachTest() {
        driver.manage().deleteAllCookies();
        // Activates this method if you want to see the photo after test finished or when it failed will be documents as capture
        listenerPhoto = new TakerPhoto(driver);
        listenerPhoto.takeScreenshot();
        driver.quit();
    }
    public void highLightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: gray; border: 2px solid red;');", element);
    }


}
