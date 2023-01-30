package scenarios;

import base.BaseTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.HomePage;
import pages.LoginPage;
import reports.ListenerTest;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(ListenerTest.class)
public class CartTests extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
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
}
