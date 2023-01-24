package base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
    }
    @AfterEach
    void afterEachTest(){
        driver.manage().deleteAllCookies();
        //takeScreenshot()
        driver.quit();
    }
    public void highLightElement(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }
    public static class Constants {

        // HOME PAGE
        public static final String HEADER_HOT_SELLERS = "Hot Sellers";
        public static final String HOT_SELLERS_INFO = "Here is what`s trending on Luma right now";


        // LOGIN PAGE
        public static final String ERROR_MESSAGE_FOR_LOGIN = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        // ACCOUNT PAGE
        public static  String MY_ACCOUNT = "My Account";
        public static  String ACCOUNT_INFORMATION = "Account Information";
        public static  String ACCOUNT_CONTACT_INFORMATION = "Contact Information";
        public static  String ACCOUNT_NEWSLETTERS_INFORMATION = "Newsletters";
        public static  String USER_NAME_INFO = "Miso Misov\nmislead4@mail.bg";
        public static  String ADDRESS_BOOK = "Address Book";
        public static  String ADDRESS_BOOK_DEFAULT_BILLING_ADDRESS = "Default Billing Address";
        public static  String ADDRESS_BOOK_DEFAULT_SHIPPING_ADDRESS = "Default Shipping Address";
    }

//void takeScreenshot() throws IOException {
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
