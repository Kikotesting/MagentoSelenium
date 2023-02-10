package scenarios;

import base.BaseTest;
import faker.FakeData;
import itemsUtils.ItemDetailsPage;
import itemsUtils.ItemsListPage;
import itemsUtils.ItemsSearchPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.GlobalPage;
import pages.ShippingPage;
import reports.ListenerTest;
import utils.CartContainer;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(ListenerTest.class)
public class PurchaseSuite extends BaseTest {

    GlobalPage globalPage;
    CartContainer cartContainer;
    ItemDetailsPage itemDetailsPage;
    ItemsSearchPage itemsSearchPage;
    ItemsListPage itemsListPage;
    ShippingPage shippingPage;
    FakeData fakeData;
    @Test
    void kiko(){
        globalPage = new GlobalPage(driver);
        cartContainer = new CartContainer(driver);
        itemsSearchPage = new ItemsSearchPage(driver);
        itemDetailsPage = new ItemDetailsPage(driver);
        itemsListPage = new ItemsListPage(driver);
        shippingPage = new ShippingPage(driver);
        fakeData = new FakeData();

        // Navigate to Gear-> Bags
        globalPage.hoverElement(globalPage.getMenuGear());
        globalPage.waitToBeVisible(globalPage.getMenuGearBags(),5);
        globalPage.hoverElementClick(globalPage.getMenuGearBags());

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
        shippingPage.setText(shippingPage.getCustomerEmailField(),fakeData.emailAddress);
        itemDetailsPage.pauseSeconds(2);
        shippingPage.setText(shippingPage.getFirstNameField(),fakeData.firstname);
        itemDetailsPage.pauseSeconds(2);
        shippingPage.setText(shippingPage.getLastNameField(),fakeData.lastname);
        itemDetailsPage.pauseSeconds(2);
        shippingPage.setText(shippingPage.getStreetAddressField(),fakeData.streetAddress);
        itemDetailsPage.pauseSeconds(2);
        shippingPage.setText(shippingPage.getCityField(),fakeData.capital);
        itemDetailsPage.pauseSeconds(2);
        shippingPage.setText(shippingPage.getProvidedZipPostalCode(),fakeData.postcode);


    }
}
