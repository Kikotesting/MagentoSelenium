import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

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

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("os", "Windows");

    }
    @AfterEach
    void afterEachTest(){
        driver.manage().deleteAllCookies();
        //takeScreenshot()
        driver.quit();
    }
//    void takeScreenshot() throws IOException {
//        TakesScreenshot camera = (TakesScreenshot)driver;
//        File screenshot = camera.getScreenshotAs(OutputType.FILE);
//
//        File pathScreenshot = new File(screenshot.getAbsolutePath());
//        File pathProject = new File("resources/screenshots");
//
//        System.out.println("Screenshot taken: "+screenshot.getAbsolutePath());
//        FileUtils.copyFileToDirectory(pathScreenshot,pathProject);
//    }
}
