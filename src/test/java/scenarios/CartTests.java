package scenarios;

import ItemsPage.ItemsSearchPage;
import base.BaseTest;
import constants.MessageConstants;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.GlobalPage;
import pages.LoginPage;
import reports.ListenerTest;
import utils.CartContainer;
import ItemsPage.ItemDetailsPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(ListenerTest.class)
public class CartTests extends BaseTest {

    LoginPage loginPage;
    CartContainer cartContainer;
    GlobalPage globalPage;
    ItemsSearchPage itemsSearchPage;
    ItemDetailsPage itemDetailsPage;
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
        cartContainer = new CartContainer(driver);
        itemsSearchPage = new ItemsSearchPage(driver);
        itemDetailsPage = new ItemDetailsPage(driver);
        // Typing women jackets
        globalPage.setText(globalPage.getSearchInputField(), "Women Jackets");
        globalPage.pressEnter(globalPage.getSearchInputField());
        // Scroll to the found elements and click on first one
        itemsSearchPage.scrollToElement(itemsSearchPage.getItemOne());
        highLightElement(driver,itemsSearchPage.getItemOne());
        itemsSearchPage.hoverElement(itemsSearchPage.getItemOne());
        itemsSearchPage.pauseSeconds(2);
        String itemOne = "Jade Yoga Jacket";
        Assertions.assertTrue(itemsSearchPage.getItemOne().getText().contains(itemOne));
        itemsSearchPage.hoverElement(itemsSearchPage.getItemOne());
        itemsSearchPage.pauseSeconds(1);
        itemDetailsPage.clickElement(itemDetailsPage.getSizeXS());
        itemsSearchPage.pauseSeconds(1);
        itemDetailsPage.clickElement(itemDetailsPage.getColorGreen());
        itemsSearchPage.pauseSeconds(1);
        itemsSearchPage.clickElement(itemsSearchPage.getAddToCartButtonItemOne());
        itemsSearchPage.pauseSeconds(4);
        itemsSearchPage.waitToBeVisible(itemsSearchPage.getMessageForAddingItemToCartContainer(),5);
        itemsSearchPage.scrollToElement(itemsSearchPage.getMessageForAddingItemToCartContainer());
        System.out.println(itemsSearchPage.getMessageForAddingItemToCartContainer().getText());
        itemsSearchPage.pauseSeconds(2);
        Assertions.assertTrue(itemsSearchPage.getMessageForAddingItemToCartContainer().getText().contains("You added "+itemOne+" to your shopping cart."));
        cartContainer.scrollToElement(cartContainer.getCartContainerButton());
        cartContainer.clickElement(cartContainer.getCartContainerButton());
        itemsSearchPage.pauseSeconds(2);
        Assertions.assertTrue(itemDetailsPage.getItemTitleName().getText().contains(itemOne));
    }

    @Test
    @Order(3)
    @DisplayName("TC-3. Delete item from Cart container")
    void deleteItemFromCartContainer(){
        globalPage = new GlobalPage(driver);
        cartContainer = new CartContainer(driver);
        itemsSearchPage = new ItemsSearchPage(driver);
        itemDetailsPage = new ItemDetailsPage(driver);

        // Typing women jackets
        globalPage.setText(globalPage.getSearchInputField(), "women wear");
        globalPage.pressEnter(globalPage.getSearchInputField());

        // Add item number two
        itemsSearchPage.waitToBeVisible(itemsSearchPage.getItemTwo(),5);
        itemsSearchPage.scrollToElement(itemsSearchPage.getItemTwo());
        highLightElement(driver,itemsSearchPage.getItemTwo());
        itemsSearchPage.hoverElement(itemsSearchPage.getItemTwo());
        itemsSearchPage.pauseSeconds(1);
        itemDetailsPage.clickElement(itemDetailsPage.getSizeXS());
        itemsSearchPage.pauseSeconds(1);
        itemDetailsPage.clickElement(itemDetailsPage.getColorBlack());
        itemsSearchPage.pauseSeconds(1);
        itemsSearchPage.clickElement(itemsSearchPage.getAddToCartButtonItemTwo());
        itemsSearchPage.pauseSeconds(1);
        itemsSearchPage.scrollToElement(itemsSearchPage.getMessageForAddingItemToCartContainer());
        System.out.println(itemsSearchPage.getMessageForAddingItemToCartContainer().getText());
        itemsSearchPage.pauseSeconds(2);
        String itemTwo = "Electra Bra Top";
        Assertions.assertTrue(itemsSearchPage.getMessageForAddingItemToCartContainer().getText().contains("You added "+itemTwo+" to your shopping cart."));
        itemsSearchPage.pauseSeconds(2);
        cartContainer.clickElement(cartContainer.getCartContainerButton());
        itemsSearchPage.pauseSeconds(2);
        Assertions.assertTrue(itemDetailsPage.getItemTitleName().getText().contains(itemTwo));
        cartContainer.clickElement(cartContainer.getCartRemove());
        itemsSearchPage.pauseSeconds(2);
        cartContainer.clickElement(cartContainer.getModalConfirm());
        cartContainer.pauseSeconds(3);
        cartContainer.waitToBeVisible(cartContainer.getEmptyCartMessage(), 5);
        Assertions.assertEquals(MessageConstants.MESSAGE_EMPTY_CARD_CONTAINER,cartContainer.getEmptyCartMessage().getText());
        System.out.println("Item was deleted from shopping cart: "+ itemsSearchPage.getItemTwo().getText());
    }

    @Test
    @Order(4)
    @DisplayName("TC-4. Add more than one item to the Cart container")
    void addMoreItemsToCartContainer(){
        globalPage = new GlobalPage(driver);
        cartContainer = new CartContainer(driver);
        itemsSearchPage = new ItemsSearchPage(driver);
        itemDetailsPage = new ItemDetailsPage(driver);
        // Typing women jackets
        globalPage.setText(globalPage.getSearchInputField(), "man");
        globalPage.pressEnter(globalPage.getSearchInputField());


    }

}
