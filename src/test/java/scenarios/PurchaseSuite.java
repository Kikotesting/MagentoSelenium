package scenarios;

import base.BaseTest;
import constants.MessageConstants;
import faker.FakeData;
import itemsUtils.ItemDetailsPage;
import itemsUtils.ItemsListPage;
import itemsUtils.ItemsSearchPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.GlobalElements;
import pages.PaymentsPage;
import pages.ShippingPage;
import reports.WatcherTest;
import utils.CartContainer;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(WatcherTest.class)
public class PurchaseSuite extends BaseTest {

    GlobalElements globalElements;
    CartContainer cartContainer;
    ItemDetailsPage itemDetailsPage;
    ItemsSearchPage itemsSearchPage;
    ItemsListPage itemsListPage;
    ShippingPage shippingPage;
    FakeData fakeData;
    PaymentsPage paymentsPage;
    @Test
    @Order(1)
    @DisplayName("TC-1. User can purchase product and proceed to checkout")
    void userCanPurchaseProductAndProceedToCheckout(){
        globalElements = new GlobalElements(driver);
        cartContainer = new CartContainer(driver);
        itemsSearchPage = new ItemsSearchPage(driver);
        itemDetailsPage = new ItemDetailsPage(driver);
        itemsListPage = new ItemsListPage(driver);
        shippingPage = new ShippingPage(driver);
        fakeData = new FakeData();
        paymentsPage = new PaymentsPage(driver);

        // Navigate to Gear-> Bags
        globalElements.hoverElement(globalElements.getMenuGear());
        globalElements.waitToBeVisible(globalElements.getMenuGearBags(),5);
        globalElements.hoverElementClick(globalElements.getMenuGearBags());

        // Click on first item
        itemsListPage.clickElement(itemsListPage.getItemOne());
        // Select 4 quantity from this product
        String itemBag = "Push It Messenger Bag";
        System.out.println(itemDetailsPage.getItemOneNameHeader().getText());
        Assertions.assertTrue(itemDetailsPage.getItemOneNameHeader().getText().contains(itemBag));
        System.out.println(itemDetailsPage.getProductPrice().getText());
        Assertions.assertTrue(itemDetailsPage.getProductPrice().getText().contains("45"));
        itemDetailsPage.clickElement(itemDetailsPage.getQuantityField());
        itemDetailsPage.setText(itemDetailsPage.getQuantityField(), "5");
        itemDetailsPage.pauseSeconds(1);
        itemDetailsPage.clickElement(itemDetailsPage.getAddToCartDetailsButton());
        itemDetailsPage.waitToBeVisible(itemDetailsPage.getMessageAddedItemToCart(),10);
        itemDetailsPage.scrollToElement(itemDetailsPage.getMessageAddedItemToCart());
        // Check the item is added to the cart but 5x quantity
        Assertions.assertTrue(itemDetailsPage.getMessageAddedItemToCart().getText().contains("You added "+itemBag+" to your shopping cart."));
        itemDetailsPage.pauseSeconds(1);
        // Open shopping cart
        cartContainer.scrollToElement(cartContainer.getCartContainerButton());
        cartContainer.clickElement(cartContainer.getCartContainerButton());
        itemsSearchPage.pauseSeconds(2);
        Assertions.assertTrue(itemDetailsPage.getItemTitleName().getText().contains(itemBag));
        Assertions.assertTrue(cartContainer.getCartBadgeCounter().getText().contains("5"));
        // Because we changed the quantity above 4x45 = 225
        Assertions.assertTrue(cartContainer.getCartSubtotalText().getText().contains("225"));
        // Process Checkout
        cartContainer.clickElement(cartContainer.getCartCheckout());
        shippingPage.setText(shippingPage.getCustomerEmailField(),fakeData.getEmailAddress());
        itemDetailsPage.pauseSeconds(5);
        shippingPage.setText(shippingPage.getFirstNameField(),fakeData.getFirstname());
        shippingPage.setText(shippingPage.getLastNameField(),fakeData.getLastname());
        shippingPage.scrollToElement(shippingPage.getStreetAddressField());
        shippingPage.setText(shippingPage.getStreetAddressField(),fakeData.getStreetAddress());
        shippingPage.setText(shippingPage.getCityField(),fakeData.getCapital());
        //California
        shippingPage.selectByValueElement(shippingPage.getStateProvinceDropdownSelector(), "12");
        itemDetailsPage.pauseSeconds(2);

        shippingPage.setText(shippingPage.getPostcode(),fakeData.getPostcode());
        itemDetailsPage.pauseSeconds(2);
        shippingPage.scrollToElement(shippingPage.getCountryDropdownSelector());
        shippingPage.selectByValueElement(shippingPage.getCountryDropdownSelector(),"US");
        itemDetailsPage.pauseSeconds(2);
        shippingPage.setText(shippingPage.getPhoneNumber(), fakeData.getPhoneNumber());
        shippingPage.clickElement(shippingPage.getRadioButtonBestWay());
        shippingPage.clickElement(shippingPage.getNextButton());
        shippingPage.pauseSeconds(3);
        Assertions.assertTrue(paymentsPage.getBillingAddress().getText().contains(fakeData.getFirstname()));
        Assertions.assertTrue(paymentsPage.getBillingAddress().getText().contains(fakeData.getLastname()));
        Assertions.assertTrue(paymentsPage.getBillingAddress().getText().contains(fakeData.getStreetAddress()));
        Assertions.assertTrue(paymentsPage.getBillingAddress().getText().contains(fakeData.getCapital()));
        Assertions.assertTrue(paymentsPage.getBillingAddress().getText().contains(fakeData.getPhoneNumber()));
        paymentsPage.clickElement(paymentsPage.getPlaceOrderButton());
        shippingPage.pauseSeconds(5);
        shippingPage.waitToBeVisible(paymentsPage.getOrderNumber(),5);
        Assertions.assertTrue(paymentsPage.getOrderNumber().getText().contains("Your order # is: "));
        Assertions.assertTrue(paymentsPage.getMessageThanksForPurchase().getText().contains(MessageConstants.MESSAGE_THANKS_FOR_PURCHASE));
    }
}
