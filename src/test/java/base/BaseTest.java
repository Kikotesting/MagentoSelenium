package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;

public class BaseTest{
    public WebDriver driver;
    TakerPhoto takerPhoto;
    @BeforeAll
    static void beforeAllTests() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void beforeEachTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-info-bars");
        options.addArguments("--disable-extensions");
        // comment this option ''headless'' for visual test on browser
        options.addArguments("headless");
        // if you want to see what happend, just remove the "options" in brackets
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        final String baseUrl = "https://magento.softwaretestingboard.com/";
        driver.get(baseUrl);
    }
    @AfterEach
    void afterEachTest() {
        driver.manage().deleteAllCookies();
        // Activates this method if you want to see the photo after test finished or when it failed will be documents as capture
        takerPhoto = new TakerPhoto(driver);
        takerPhoto.takeScreenshot();
        driver.quit();
        System.out.println("Test name of photo: "+takerPhoto.getNewNameOfPhoto());
    }




}
