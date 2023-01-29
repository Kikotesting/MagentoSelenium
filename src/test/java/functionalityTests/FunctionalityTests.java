package functionalityTests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.WomenPage;

public class FunctionalityTests extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    WomenPage womenPage;

    @Test
    @Order(1)
    @DisplayName("TC-1. Get correct URL from each page")
    void getUrlFromEachPage() {

        homePage = new HomePage(driver);
        String baseUrl = "https://magento.softwaretestingboard.com/";

        Assertions.assertEquals(baseUrl,driver.getCurrentUrl());
        loginPage = new LoginPage(driver);
        loginPage.defaultLogin();

        homePage.hoverElement(homePage.menuWomen);
        homePage.waitToBeVisible(homePage.menuWomen_Tops,2);
        homePage.hoverElementClick(homePage.menuWomen_Tops);

        String womenMenuTopsUrl = "https://magento.softwaretestingboard.com/women/tops-women.html";
        womenPage = new WomenPage(driver);
        Assertions.assertEquals(womenMenuTopsUrl,driver.getCurrentUrl());



        driver.navigate().back();
        String womenMenuUrl = "https://magento.softwaretestingboard.com/women";
        Assertions.assertEquals(womenMenuUrl,driver.getCurrentUrl());

    }
    @Test
    @Order(2)
    @DisplayName("TC-2. Sort items on Women-Tops-Page by Price")
    void sortItemsByProductionName() {
        homePage = new HomePage(driver);

        homePage.hoverElement(homePage.menuWomen);
        homePage.waitToBeVisible(homePage.menuWomen_Tops,2);
        homePage.hoverElementClick(homePage.menuWomen_Tops);

        womenPage = new WomenPage(driver);
        womenPage.scrollToElement(womenPage.toolbarProducts);

        womenPage.waitToBeVisible(womenPage.productPositionItemOne, 5);
        womenPage.scrollToElement(womenPage.productPriceItemOne);
        womenPage.scrollToPixels(200);
        String savePositionNameOne = womenPage.productPositionItemOne.getText();
        System.out.println(savePositionNameOne + "\n==========================");

        womenPage.selectByVisibleTextElement(womenPage.selectorSortBy,"Price");
        womenPage.pauseSeconds(2);

        womenPage.waitToBeVisible(womenPage.productPriceItemOne,5 );
        womenPage.scrollToElement(womenPage.productPriceItemOne);
        womenPage.scrollToPixels(200);
        String savePriceNameOne = womenPage.productPriceItemOne.getText();
        System.out.println(savePriceNameOne);
        womenPage.pauseSeconds(2);

        Assertions.assertNotEquals(savePositionNameOne,savePriceNameOne);
    }

    @Test
    @Order(3)
    @DisplayName("TC-3. Set Ascending/Descending directions ")
    void setAscendingOrDescendingDirectionOnItems() {
        homePage = new HomePage(driver);

        homePage.hoverElement(homePage.menuWomen);
        homePage.waitToBeVisible(homePage.menuWomen_Tops,2);
        homePage.hoverElementClick(homePage.menuWomen_Tops);

        womenPage = new WomenPage(driver);
        womenPage.scrollToElement(womenPage.toolbarProducts);

        // By default is Ascending
        womenPage.selectByVisibleTextElement(womenPage.selectorSortBy,"Price");
        womenPage.pauseSeconds(2);
        womenPage.waitToBeVisible(womenPage.productPriceItemOne,5 );
        womenPage.scrollToElement(womenPage.productPriceItemOne);
        womenPage.scrollToPixels(100);
        String savePriceNameAscending = womenPage.productPriceItemOne.getText();
        System.out.println(savePriceNameAscending);
        womenPage.pauseSeconds(2);
        // Change order
        womenPage.orderDescendingButton.click();
        womenPage.pauseSeconds(2);
        womenPage.scrollToElement(womenPage.productPriceItemOne);
        womenPage.scrollToPixels(100);
        String savePriceNameDescending = womenPage.productPriceItemOne.getText();
        System.out.println(savePriceNameDescending);
        womenPage.pauseSeconds(2);

        Assertions.assertNotEquals(savePriceNameAscending,savePriceNameDescending);
    }

}
