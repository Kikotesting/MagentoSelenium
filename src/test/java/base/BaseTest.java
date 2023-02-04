package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import reports.ListenerPhoto;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    ListenerPhoto listenerPhoto;

    @BeforeAll
    static void beforeAllTests() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void beforeEachTest() {
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-info-bars");
        options.addArguments("--disable-extensions");
        options.getLogLevel();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        final String baseUrl = "https://magento.softwaretestingboard.com/";
        driver.get(baseUrl);
    }

    @AfterEach
    void afterEachTest() throws IOException {
        driver.manage().deleteAllCookies();
        // Activates this method if you want to see the photo after test finished or when it failed will be documents as capture
        listenerPhoto = new ListenerPhoto(driver);
        listenerPhoto.takeScreenshot();
        driver.quit();
    }

    public void highLightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }


}
