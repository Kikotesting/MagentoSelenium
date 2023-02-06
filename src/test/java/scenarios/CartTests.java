package scenarios;

import base.BaseTest;
import constants.MessageConstants;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.GlobalPage;
import pages.LoginPage;
import reports.ListenerTest;
import utils.CartContainer;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(ListenerTest.class)
public class CartTests extends BaseTest {

    LoginPage loginPage;
    CartContainer cartContainer;
    GlobalPage globalPage;
    @Test
    @Order(1)
    @DisplayName("TC-1. Check Cart container which is empty without added product")
    void verifyEmptyCartContainer(){
        globalPage = new GlobalPage(driver);
        loginPage = new LoginPage(driver);
        cartContainer = new CartContainer(driver);
        globalPage.clickElement(globalPage.getSignInTextButton());
        loginPage.defaultLogin();
        cartContainer.clickElement(cartContainer.getCartContainerButton());
        cartContainer.waitToBeVisible(cartContainer.getEmptyCartMessage(), 5);
        Assertions.assertEquals(MessageConstants.MESSAGE_EMPTY_CARD_CONTAINER,cartContainer.getEmptyCartMessage().getText());
    }

//    @Test
//    @Order(2)
//    @DisplayName("TC-2. Add item to the Cart container")

//    @Test
//    @Order(2)
//    @DisplayName("TC-2. Add more than one item to the Cart container")

//    @Test
//    @Order(3)
//    @DisplayName("TC-3. Delete item from Cart container")

}
