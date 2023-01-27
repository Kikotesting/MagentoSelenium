package base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    @BeforeAll
    static void beforeAllTests(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void beforeEachTest(){
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
        //takeScreenshot();
        driver.quit();
    }
    public void highLightElement(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }
    void  takeScreenshot() throws IOException {
        TakesScreenshot camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);

        File pathScreenshot = new File(screenshot.getAbsolutePath());
        File pathProject = new File("resources/screenshots");

        System.out.println("Screenshot taken: "+screenshot.getAbsolutePath());
        FileUtils.copyFileToDirectory(pathScreenshot,pathProject);
    }




}
