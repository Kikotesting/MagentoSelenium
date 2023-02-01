package scenarios;

import base.BaseTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.HomePage;
import pages.LoginPage;
import pages.LumaYogaPage;
import pages.ProductPage;
import reports.ListenerTest;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(ListenerTest.class)
public class CartTests extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    LumaYogaPage lumaPage;
    ProductPage productPage;
    @Test
    @Order(1)
    @DisplayName("TC-1. Add item to the cart")
    void addItemToCart() {
        homePage = new HomePage(driver);
        homePage.clickHeaderSignInButton();
        loginPage = new LoginPage(driver);
        loginPage.defaultLogin();
        homePage.newLumaYogaBanner.click();
        String lumaYogaUrl = "https://magento.softwaretestingboard.com/collections/yoga-new.html";
        Assertions.assertEquals(lumaYogaUrl,driver.getCurrentUrl());
        homePage.scrollToElement(homePage.sidebarLeftMenu);
        homePage.listView.click();
        String productName = homePage.productEchoFit.getText();
        Assertions.assertTrue(productName.contains("Echo Fit"));
        homePage.chooseColorPinkForEchoFit.click();
        homePage.pauseSeconds(1);
        homePage.chooseSize28EchoFit.click();
        homePage.pauseSeconds(1);
        homePage.addToCartButtonForEchoFit.click();
        homePage.scrollToElement(homePage.messageForAdded);
        String addItemToCart = "You added Echo Fit Compression Short to your shopping cart.";
        Assertions.assertEquals(homePage.messageForAdded.getText(),addItemToCart);
        homePage.scrollToElement(homePage.showCartIconBtn);
        homePage.showCartIconBtn.click();
        homePage.pauseSeconds(1);
        String productNameInCart = homePage.itemInCartNameForEchoFit.getText();
        Assertions.assertTrue(productNameInCart.contains("Echo Fit"));
    }
    @Test
    @Order(2)
    @DisplayName("TC-2. Add more than one item to the cart")
    void addMoreItemToTheCart() {
        homePage = new HomePage(driver);
        homePage.clickHeaderSignInButton();
        loginPage = new LoginPage(driver);
        loginPage.defaultLogin();
        homePage.newLumaYogaBanner.click();
        String lumaYogaUrl = "https://magento.softwaretestingboard.com/collections/yoga-new.html";
        Assertions.assertEquals(lumaYogaUrl,driver.getCurrentUrl());
        lumaPage = new LumaYogaPage(driver);

        lumaPage.scrollToElement(lumaPage.gwenShortItem);
        lumaPage.hoverElement(lumaPage.gwenShortItem);
        lumaPage.gwenShortItem.click();
        lumaPage.pauseSeconds(2);
        productPage = new ProductPage(driver);
        productPage.scrollToPixels(150);
        productPage.size32.click();
        lumaPage.pauseSeconds(2);
        productPage.blueColor.click();
        lumaPage.pauseSeconds(2);
        productPage.addToCartButton.click();
        productPage.pauseSeconds(2);
        lumaPage.scrollToElement(productPage.messageAddedToCart);
        Assertions.assertEquals("You added Gwen Drawstring Bike Short to your shopping cart."
                ,productPage.messageAddedToCart.getText());
        homePage.scrollToElement(homePage.showCartIconBtn);
        homePage.showCartIconBtn.click();
        homePage.pauseSeconds(1);
        String gwenItem = lumaPage.gwenCartNameItem.getText();
        Assertions.assertTrue(gwenItem.contains("Gwen Drawstring Bike Short"));
        productPage.closeCartButton.click();

        driver.navigate().back();
        lumaPage.scrollToElement(lumaPage.fionnaShortItem);
        lumaPage.hoverElement(lumaPage.fionnaShortItem);
        lumaPage.fionnaShortItem.click();
        lumaPage.pauseSeconds(2);
        productPage.scrollToPixels(150);
        productPage.size32.click();
        lumaPage.pauseSeconds(2);
        productPage.redColor.click();
        productPage.addToCartButton.click();
        productPage.pauseSeconds(2);
        Assertions.assertEquals("You added Fiona Fitness Short to your shopping cart."
                ,productPage.messageAddedToCart.getText());
        homePage.scrollToElement(homePage.showCartIconBtn);
        homePage.showCartIconBtn.click();
        homePage.pauseSeconds(1);
        String fionaItem = lumaPage.fionnaCartNameItem.getText();
        Assertions.assertTrue(fionaItem.contains("Fiona Fitness Short"));
        Assertions.assertTrue(gwenItem.contains("Gwen Drawstring Bike Short"));
        Assertions.assertEquals("2",productPage.counterItems.getText());
        productPage.closeCartButton.click();
    }
}
