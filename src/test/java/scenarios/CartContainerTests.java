package scenarios;

import itemsUtils.ItemsSearchPage;
import base.BaseTest;
import constants.MessageConstants;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.GlobalElements;
import pages.LoginPage;
import reports.WatcherTest;
import utils.CartContainer;
import itemsUtils.ItemDetailsPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(WatcherTest.class)
public class CartContainerTests extends BaseTest {

    LoginPage loginPage;
    CartContainer cartContainer;
    GlobalElements globalElements;
    ItemsSearchPage itemsSearchPage;
    ItemDetailsPage itemDetailsPage;
    @Test
    @Order(1)
    @DisplayName("TC-1. Check Cart container which is empty without added product")
    void verifyEmptyCartContainer(){
        globalElements = new GlobalElements(driver);
        loginPage = new LoginPage(driver);
        cartContainer = new CartContainer(driver);
        globalElements.clickElement(globalElements.getSignInTextButton());
        loginPage.defaultLogin();
        cartContainer.clickElement(cartContainer.getCartContainerButton());
        cartContainer.waitToBeVisible(cartContainer.getEmptyCartMessage(), 5);
        Assertions.assertEquals(MessageConstants.MESSAGE_EMPTY_CARD_CONTAINER,cartContainer.getEmptyCartMessage().getText());
    }

    @Test
    @Order(2)
    @DisplayName("TC-2. Add item to the Cart container")
    void addItemToCartContainer(){
        globalElements = new GlobalElements(driver);
        cartContainer = new CartContainer(driver);
        itemsSearchPage = new ItemsSearchPage(driver);
        itemDetailsPage = new ItemDetailsPage(driver);
        // Typing women jackets
        globalElements.setText(globalElements.getSearchInputField(), "Women Jackets");
        globalElements.pressEnter(globalElements.getSearchInputField());
        // Scroll to the found elements and click on first one
        itemsSearchPage.scrollToElement(itemsSearchPage.getItemOne());
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
        globalElements = new GlobalElements(driver);
        cartContainer = new CartContainer(driver);
        itemsSearchPage = new ItemsSearchPage(driver);
        itemDetailsPage = new ItemDetailsPage(driver);

        // Typing women jackets
        globalElements.setText(globalElements.getSearchInputField(), "women wear");
        globalElements.pressEnter(globalElements.getSearchInputField());

        // Add item number two
        itemsSearchPage.waitToBeVisible(itemsSearchPage.getItemTwo(),5);
        itemsSearchPage.scrollToElement(itemsSearchPage.getItemTwo());
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
        globalElements = new GlobalElements(driver);
        cartContainer = new CartContainer(driver);
        itemsSearchPage = new ItemsSearchPage(driver);
        itemDetailsPage = new ItemDetailsPage(driver);

        // Search for first product
        globalElements.setText(globalElements.getSearchInputField(), "man");
        globalElements.pressEnter(globalElements.getSearchInputField());

        // Add first item Rionna
        String itemRionna = itemsSearchPage.getItemOne().getText();
        itemsSearchPage.hoverElement(itemsSearchPage.getItemOne());
        itemsSearchPage.pauseSeconds(1);
        itemDetailsPage.clickElement(itemDetailsPage.getSizeXS());
        itemsSearchPage.pauseSeconds(1);
        itemDetailsPage.clickElement(itemDetailsPage.getColorRed());
        itemsSearchPage.pauseSeconds(1);
        itemsSearchPage.clickElement(itemsSearchPage.getAddToCartButtonItemOne());
        itemsSearchPage.waitToBeVisible(itemsSearchPage.getMessageForAddingItemToCartContainer(),5);
        itemsSearchPage.scrollToElement(itemsSearchPage.getMessageForAddingItemToCartContainer());
        System.out.println(itemsSearchPage.getMessageForAddingItemToCartContainer().getText());
        itemsSearchPage.pauseSeconds(2);
        Assertions.assertTrue(itemsSearchPage.getMessageForAddingItemToCartContainer().getText().contains("You added "+itemRionna+" to your shopping cart."));

        // Search for second product
        globalElements.setText(globalElements.getSearchInputField(), "josie");
        globalElements.pressEnter(globalElements.getSearchInputField());
        // Add second item Josie
        String itemJosie = itemsSearchPage.getItemOne().getText();
        itemsSearchPage.hoverElement(itemsSearchPage.getItemOne());
        itemsSearchPage.pauseSeconds(1);
        itemDetailsPage.clickElement(itemDetailsPage.getSizeXS());
        itemsSearchPage.pauseSeconds(1);
        itemDetailsPage.clickElement(itemDetailsPage.getColorBlue());
        itemsSearchPage.pauseSeconds(1);
        itemsSearchPage.clickElement(itemsSearchPage.getAddToCartButtonItemOne());
        itemsSearchPage.waitToBeVisible(itemsSearchPage.getMessageForAddingItemToCartContainer(),5);
        itemsSearchPage.scrollToElement(itemsSearchPage.getMessageForAddingItemToCartContainer());
        System.out.println(itemsSearchPage.getMessageForAddingItemToCartContainer().getText());
        itemsSearchPage.pauseSeconds(2);
        Assertions.assertTrue(itemsSearchPage.getMessageForAddingItemToCartContainer().getText().contains("You added "+itemJosie+" to your shopping cart."));
        itemsSearchPage.pauseSeconds(1);
        cartContainer.scrollToElement(cartContainer.getCartContainerButton());
        cartContainer.clickElement(cartContainer.getCartContainerButton());
        itemsSearchPage.pauseSeconds(1);
        System.out.println("items counter is: " + cartContainer.getCartBadgeCounter().getText());
        Assertions.assertTrue(cartContainer.getCartBadgeCounter().getText().contains("2"));
        // Ordered by Alphabetical, so the josie product is first to check!
        Assertions.assertTrue(cartContainer.getCartContainerItemNameOne().getText().contains(itemJosie));
        Assertions.assertTrue(cartContainer.getCartContainerItemNameTwo().getText().contains(itemRionna));
    }

}
