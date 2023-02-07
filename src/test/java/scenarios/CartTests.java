package scenarios;

import ItemsPage.SearchItemsView;
import base.BaseTest;
import constants.MessageConstants;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.GlobalPage;
import pages.LoginPage;
import reports.ListenerTest;
import utils.CartContainer;
import utils.ProductDetails;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(ListenerTest.class)
public class CartTests extends BaseTest {

    LoginPage loginPage;
    CartContainer cartContainer;
    GlobalPage globalPage;
    SearchItemsView searchItemsView;
    ProductDetails productDetails;
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

    @Test
    @Order(2)
    @DisplayName("TC-2. Add item to the Cart container")
    void addItemToCartContainer(){
        globalPage = new GlobalPage(driver);
        loginPage = new LoginPage(driver);
        cartContainer = new CartContainer(driver);
        searchItemsView = new SearchItemsView(driver);
        productDetails = new ProductDetails(driver);
        // Typing women jackets
        globalPage.setText(globalPage.getSearchInputField(), "Women Jackets");
        globalPage.pressEnter(globalPage.getSearchInputField());
        // Scroll to the found elements and click on first one
        searchItemsView.scrollToElement(searchItemsView.getItemOne());
        highLightElement(driver,searchItemsView.getItemOne());
        searchItemsView.hoverElement(searchItemsView.getItemOne());
        searchItemsView.pauseSeconds(2);
        String itemOne = "Jade Yoga Jacket";
        Assertions.assertTrue(searchItemsView.getItemOne().getText().contains(itemOne));
        searchItemsView.hoverElement(searchItemsView.getItemOne());
        searchItemsView.pauseSeconds(1);
        productDetails.clickElement(productDetails.getSizeXS());
        searchItemsView.pauseSeconds(1);
        productDetails.clickElement(productDetails.getColorGreen());
        searchItemsView.pauseSeconds(1);
        searchItemsView.clickElement(searchItemsView.getAddToCartButtonItemOne());
        searchItemsView.pauseSeconds(4);
        searchItemsView.waitToBeVisible(searchItemsView.getMessageForAddingItemToCartContainer(),5);
        searchItemsView.scrollToElement(searchItemsView.getMessageForAddingItemToCartContainer());
        System.out.println(searchItemsView.getMessageForAddingItemToCartContainer().getText());
        searchItemsView.pauseSeconds(2);
        Assertions.assertTrue(searchItemsView.getMessageForAddingItemToCartContainer().getText().contains("You added "+itemOne+" to your shopping cart."));
        cartContainer.scrollToElement(cartContainer.getCartContainerButton());
        cartContainer.clickElement(cartContainer.getCartContainerButton());
        searchItemsView.pauseSeconds(2);
        Assertions.assertTrue(productDetails.getItemTitleName().getText().contains(itemOne));
    }

//    @Test
//    @Order(2)
//    @DisplayName("TC-2. Add more than one item to the Cart container")

//    @Test
//    @Order(3)
//    @DisplayName("TC-3. Delete item from Cart container")

}
