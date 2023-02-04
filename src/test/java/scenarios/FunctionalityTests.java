package scenarios;

import ItemsPage.SearchItemsView;
import ItemsPage.WomenTopsItemsView;
import base.BaseTest;
import constants.MessageConstants;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import reports.ListenerTest;
import utils.FakeData;
import utils.GlobalPage;
import ItemsPage.ItemsView;
import utils.ProductDetails;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(ListenerTest.class)
public class FunctionalityTests extends BaseTest {
//    }
//    @Test
//    @Order(2)
//    @DisplayName("TC-2. Sort items on Women-Tops-Page by Price")
//    void sortItemsByProductionName() {
//        homePage = new HomePage(driver);
//
//        homePage.hoverElement(homePage.menuWomen);
//        homePage.waitToBeVisible(homePage.menuWomenTops,2);
//        homePage.hoverElementClick(homePage.menuWomenTops);
//
//        womenPage = new WomenPage(driver);
//        womenPage.scrollToElement(womenPage.toolbarProducts);
//
//        womenPage.waitToBeVisible(womenPage.productPositionItemOne, 5);
//        womenPage.scrollToElement(womenPage.productPriceItemOne);
//        womenPage.scrollToPixels(200);
//        String savePositionNameOne = womenPage.productPositionItemOne.getText();
//        System.out.println(savePositionNameOne + "\n==========================");
//
//        womenPage.selectByVisibleTextElement(womenPage.selectorSortBy,"Price");
//        womenPage.pauseSeconds(2);
//
//        womenPage.waitToBeVisible(womenPage.productPriceItemOne,5 );
//        womenPage.scrollToElement(womenPage.productPriceItemOne);
//        womenPage.scrollToPixels(200);
//        String savePriceNameOne = womenPage.productPriceItemOne.getText();
//        System.out.println(savePriceNameOne);
//        womenPage.pauseSeconds(2);
//
//        Assertions.assertNotEquals(savePositionNameOne,savePriceNameOne);
//    }
//
//    @Test
//    @Order(3)
//    @DisplayName("TC-3. Set Descending directions ")
//    void setDescendingDirectionOnItems() {
//        homePage = new HomePage(driver);
//
//        homePage.hoverElement(homePage.menuWomen);
//        homePage.waitToBeVisible(homePage.menuWomenTops,2);
//        homePage.hoverElementClick(homePage.menuWomenTops);
//
//        womenPage = new WomenPage(driver);
//        womenPage.scrollToElement(womenPage.toolbarProducts);
//
//        // By default is Ascending
//        womenPage.selectByVisibleTextElement(womenPage.selectorSortBy,"Price");
//        womenPage.pauseSeconds(2);
//        womenPage.waitToBeVisible(womenPage.productPriceItemOne,5 );
//        womenPage.scrollToElement(womenPage.productPriceItemOne);
//        womenPage.scrollToPixels(100);
//        String savePriceNameAscending = womenPage.productPriceItemOne.getText();
//        System.out.println(savePriceNameAscending);
//        womenPage.pauseSeconds(2);
//        // Change order
//        womenPage.orderDescendingButton.click();
//        womenPage.pauseSeconds(2);
//        womenPage.scrollToElement(womenPage.productPriceItemOne);
//        womenPage.scrollToPixels(100);
//        String savePriceNameDescending = womenPage.productPriceItemOne.getText();
//        System.out.println(savePriceNameDescending);
//        womenPage.pauseSeconds(2);
//
//        Assertions.assertNotEquals(savePriceNameAscending,savePriceNameDescending);
//    }
    GlobalPage globalPage;
    FakeData fakeData;
    SearchItemsView searchItemsView;
    ItemsView itemsView;
    WomenTopsItemsView womenTopsItemsView;
    ProductDetails productDetails;
    @Test
    @DisplayName("TC-1. Lookup items with valid data by color")
    @Order(1)
    void searchItemsWithValidDataByColor(){
        //Initialize objects from classes
        globalPage = new GlobalPage(driver);
        productDetails = new ProductDetails(driver);
        searchItemsView = new SearchItemsView(driver);

        // Typing valid data in the search input bar
        globalPage.setText(globalPage.getSearchInputField(), "Blue");
        globalPage.pressEnter(globalPage.getSearchInputField());
        // Scroll to the found elements and check if its exists and color blue options is displayed
        searchItemsView.scrollToElement(searchItemsView.getItemOne());
        highLightElement(driver,searchItemsView.getItemOne());
        searchItemsView.hoverElement(searchItemsView.getItemOne());
        searchItemsView.pauseSeconds(2);
        String itemNameChloe = "Chloe Compete Tank";
        Assertions.assertTrue(searchItemsView.getItemOne().getText().contains(itemNameChloe));
        productDetails.getColorBlue().click();
        Assertions.assertTrue(productDetails.getColorBlue().isDisplayed());
        searchItemsView.scrollToElement(searchItemsView.getItemThree());
        highLightElement(driver,searchItemsView.getItemThree());
        searchItemsView.hoverElement(searchItemsView.getItemThree());
        searchItemsView.pauseSeconds(2);
        String itemNameBella = "Bella Tank";
        Assertions.assertTrue(searchItemsView.getItemThree().getText().contains(itemNameBella));
        productDetails.getColorBlue().click();
        Assertions.assertTrue(productDetails.getColorBlue().isDisplayed());
    }
    @Test
    @DisplayName("TC-2. Lookup items with Invalid data")
    @Order(2)
    void searchItemsWithInvalidData(){
        //Initialize objects from classes
        globalPage = new GlobalPage(driver);
        itemsView = new ItemsView(driver);
        // Typing valid data in the search input bar
        globalPage.setText(globalPage.getSearchInputField(), "jhsddhjgh");
        globalPage.pressEnter(globalPage.getSearchInputField());
        globalPage.waitToBeVisible(itemsView.getNoResults(), 3);
        Assertions.assertEquals(MessageConstants.MESSAGE_NO_RESULT,itemsView.getNoResults().getText());
    }
    @Test
    @DisplayName("TC-3. Get correct URL from each page")
    @Order(3)
    void getUrlFromDifferentPages(){
        globalPage = new GlobalPage(driver);
        womenTopsItemsView = new WomenTopsItemsView(driver);

        String baseUrl = "https://magento.softwaretestingboard.com/";
        Assertions.assertEquals(baseUrl,driver.getCurrentUrl());
        String menuWomenUrl = "https://magento.softwaretestingboard.com/women.html";
        globalPage.clickElement(globalPage.getMenuWomen());
        Assertions.assertEquals(menuWomenUrl,driver.getCurrentUrl());
        globalPage.hoverElement(globalPage.getMenuWomen());
        globalPage.waitToBeVisible(globalPage.getMenuWomenTops(), 5);
        globalPage.hoverElementClick(globalPage.getMenuWomenTops());
        String menuWomenTopsUrl = "https://magento.softwaretestingboard.com/women/tops-women.html";
        Assertions.assertEquals(menuWomenTopsUrl,driver.getCurrentUrl());

        womenTopsItemsView.scrollToElement(womenTopsItemsView.getItemOne());
        womenTopsItemsView.hoverElementClick(womenTopsItemsView.getItemOne());
        String menuWomenTopsFirstItem = "https://magento.softwaretestingboard.com/breathe-easy-tank.html";
        Assertions.assertEquals(menuWomenTopsFirstItem,driver.getCurrentUrl());
        System.out.println("Response URLs:"+"\n"+baseUrl+"\n"+menuWomenUrl+"\n"+menuWomenTopsUrl+"\n"+menuWomenTopsFirstItem);
    }
    @Test
    @DisplayName("TC-4. Subscribe to a newsletter for the first time")
    @Order(4)
    void subscribesNewsletterForFirstTime(){
        globalPage = new GlobalPage(driver);
        fakeData = new FakeData();
        globalPage.scrollToElement(globalPage.getNewsLetterField());
        globalPage.setText(globalPage.getNewsLetterField(), fakeData.emailAddress);
        globalPage.clickElement(globalPage.getSubscribeButton());
        globalPage.pauseSeconds(1);
        globalPage.waitToBeVisible(globalPage.getMessageSubscription(), 3);
        highLightElement(driver,globalPage.getMessageSubscription());
        int trials = 0;
        if(globalPage.getMessageSubscription().getText().equals(MessageConstants.MESSAGE_FOR_SUBSCRIBE)){
            Assertions.assertEquals(MessageConstants.MESSAGE_FOR_SUBSCRIBE, globalPage.getMessageSubscription().getText());
        }
        else {
            while(globalPage.getMessageSubscription().getText().equals(MessageConstants.MESSAGE_ALREADY_SUBSCRIBED)){
                trials +=1;
                globalPage.scrollToElement(globalPage.getNewsLetterField());
                globalPage.setText(globalPage.getNewsLetterField(), fakeData.emailAddress);
                globalPage.clickElement(globalPage.getSubscribeButton());
                globalPage.pauseSeconds(1);
                globalPage.waitToBeVisible(globalPage.getMessageSubscription(), 3);
                highLightElement(driver,globalPage.getMessageSubscription());
            }
            System.out.println("Trials for unique emails: " + trials);
        }
        Assertions.assertEquals(MessageConstants.MESSAGE_FOR_SUBSCRIBE,globalPage.getMessageSubscription().getText());
    }

    @Test
    @DisplayName("TC-5. Subscribe to a newsletter with a user who has already subscribed")
    @Order(5)
    void subscribesForNewsletterWithAlreadySubscribedEmail(){
        globalPage = new GlobalPage(driver);
        globalPage.scrollToElement(globalPage.getNewsLetterField());
        globalPage.setText(globalPage.getNewsLetterField(), "mislead4@mail.bg");
        globalPage.clickElement(globalPage.getSubscribeButton());
        globalPage.pauseSeconds(1);
        globalPage.waitToBeVisible(globalPage.getMessageSubscription(), 3);
        highLightElement(driver,globalPage.getMessageSubscription());
        if (globalPage.getMessageSubscription().getText().equals(MessageConstants.MESSAGE_ALREADY_SUBSCRIBED)) {
            Assertions.assertEquals(MessageConstants.MESSAGE_ALREADY_SUBSCRIBED,globalPage.getMessageSubscription().getText());
            System.out.println("Correct message!");
        } else {
            Assertions.assertEquals(MessageConstants.MESSAGE_INVALID_SUBSCRIBE,globalPage.getMessageSubscription().getText());
            System.out.println("Form Invalid key message!");
        }
    }



}
