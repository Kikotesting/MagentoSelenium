package base;
import listeners.ListenerPhoto;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    ListenerPhoto reports;
    public WebDriver driver;
    @BeforeAll
    static void beforeAllTests(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void beforeEachTest(){
            System.out.println(" Executing on Chrome browser");
            driver = new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-info-bars");
            options.addArguments("--disable-extensions");
            options.setHeadless(false);
            options.getLogLevel();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().window().maximize();
            driver.get("https://magento.softwaretestingboard.com/");
        }

    @AfterEach
    void afterEachTest() throws IOException {
        driver.manage().deleteAllCookies();
        // Activates this method if you want to see the photo after test finished or when it failed will be documents as capture
        // reports = new ListenerPhoto(driver);
        // reports.takeScreenshot();
        driver.quit();
    }

    public void highLightElement(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }





}
