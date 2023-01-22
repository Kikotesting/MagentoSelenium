import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.events.WebDriverListener;
import utils.locators.HomePageLocators;
import utils.locators.LoginPageLocators;

public class LoginTests extends BaseTest {

    HomePageLocators homePageLocators;
    LoginPageLocators loginPageLocators;
    @Test
    @DisplayName("Login with valid username and password")

    void userCanLoginWithValidCredentials(){

    }
    @Test
    @DisplayName("Check")

    void Check(){
        homePageLocators = new HomePageLocators(driver);
        homePageLocators.signIn_Btn.click();
        driver.navigate().back();
    }
}
