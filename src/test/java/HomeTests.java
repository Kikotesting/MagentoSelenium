import base.BaseTest;
import baseUtils.Constants;
import io.netty.util.Constant;
import listeners.Listener;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Keys;
import pages.HomePage;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HomeTests extends BaseTest {

    HomePage homePage;

    @Test
    @Order(1)
    @ExtendWith(Listener.class)
    @DisplayName("TC-1. Search with invalid data")
    void searchWithInvalidData(){
        homePage = new HomePage(driver);

        homePage.searchInputField.click();
        homePage.searchInputField.sendKeys("JJJ&");
        homePage.searchInputField.sendKeys(Keys.ENTER);
        highLightElement(driver,homePage.searchNoResultMessage);
        homePage.pauseSeconds(1);
        Assertions.assertEquals(Constants.SEARCH_NO_RESULT,homePage.searchNoResultMessage.getText());
    }
    @Test
    @Order(2)
    @ExtendWith(Listener.class)
    @DisplayName("TC-2. Search with valid data")
    void searchWithValidData(){
        homePage = new HomePage(driver);

        homePage.searchInputField.click();
        homePage.searchInputField.sendKeys("Blue");
        homePage.searchInputField.sendKeys(Keys.ENTER);
        String foundItems = "items";
        Assertions.assertTrue(foundItems.contains("items"));

    }


}
