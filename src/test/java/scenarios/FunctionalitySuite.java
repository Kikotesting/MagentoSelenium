package scenarios;

import constants.UrlConstants;
import itemsUtils.ItemsListPage;
import base.BaseTest;
import constants.MessageConstants;
import itemsUtils.ItemsSearchPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import reports.WatcherTest;
import faker.FakeData;
import pages.GlobalPage;
import itemsUtils.ItemsView;
import itemsUtils.ItemDetailsPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(WatcherTest.class)
public class FunctionalitySuite extends BaseTest{
    GlobalPage globalPage;
    FakeData fakeData;
    ItemsListPage itemsPage;
    ItemsView itemsView;
    ItemDetailsPage itemDetailsPage;
    ItemsSearchPage itemsSearchPage;

    @Test
    @DisplayName("TC-1. Search items with valid data by color")
    @Order(1)
    void searchItemsWithValidDataByColor(){
        //Initialize objects from classes
        globalPage = new GlobalPage(driver);
        itemDetailsPage = new ItemDetailsPage(driver);
        itemsSearchPage = new ItemsSearchPage(driver);

        // Typing valid data in the search input bar
        globalPage.setText(globalPage.getSearchInputField(), "Blue");
        globalPage.pressEnter(globalPage.getSearchInputField());
        // Scroll to the found elements and check if its exists and color blue options is displayed
        itemsSearchPage.scrollToElement(itemsSearchPage.getItemOne());
        highLightElement(driver,itemsSearchPage.getItemOne());
        itemsSearchPage.hoverElement(itemsSearchPage.getItemOne());
        itemsSearchPage.pauseSeconds(2);
        String itemNameChloe = "Chloe Compete Tank";
        Assertions.assertTrue(itemsSearchPage.getItemOne().getText().contains(itemNameChloe));
        itemDetailsPage.getColorBlue().click();
        Assertions.assertTrue(itemDetailsPage.getColorBlue().isDisplayed());
        itemsSearchPage.scrollToElement(itemsSearchPage.getItemThree());
        highLightElement(driver,itemsSearchPage.getItemThree());
        itemsSearchPage.hoverElement(itemsSearchPage.getItemThree());
        itemsSearchPage.pauseSeconds(2);
        String itemNameBella = "Bella Tank";
        Assertions.assertTrue(itemsSearchPage.getItemThree().getText().contains(itemNameBella));
        itemDetailsPage.getColorBlue().click();
        Assertions.assertTrue(itemDetailsPage.getColorBlue().isDisplayed());
    }
    @Test
    @DisplayName("TC-2. Search items with Invalid data")
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
        itemsPage = new ItemsListPage(driver);

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

        itemsPage.scrollToElement(itemsPage.getItemOne());
        itemsPage.hoverElementClick(itemsPage.getItemOne());
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
        globalPage.setText(globalPage.getNewsLetterField(), fakeData.getEmailAddress());
        globalPage.clickElement(globalPage.getSubscribeButton());
        globalPage.pauseSeconds(1);
        globalPage.waitToBeVisible(globalPage.getMessageSubscription(), 3);
        highLightElement(driver,globalPage.getMessageSubscription());
        int trials = 0;
        if(globalPage.getMessageSubscription().getText().equals(MessageConstants.MESSAGE_FOR_SUBSCRIBE)){
            Assertions.assertEquals(MessageConstants.MESSAGE_FOR_SUBSCRIBE, globalPage.getMessageSubscription().getText());
        } else if (globalPage.getMessageSubscription().getText().equals(MessageConstants.MESSAGE_INVALID_SUBSCRIBE)) {
            Assertions.assertEquals(MessageConstants.MESSAGE_INVALID_SUBSCRIBE,globalPage.getMessageSubscription().getText());
            System.out.println("Form Invalid key message!");
        } else {
            while(globalPage.getMessageSubscription().getText().equals(MessageConstants.MESSAGE_ALREADY_SUBSCRIBED)){
                trials +=1;
                globalPage.scrollToElement(globalPage.getNewsLetterField());
                globalPage.setText(globalPage.getNewsLetterField(), fakeData.getEmailAddress());
                globalPage.clickElement(globalPage.getSubscribeButton());
                globalPage.pauseSeconds(1);
                globalPage.waitToBeVisible(globalPage.getMessageSubscription(), 3);
                highLightElement(driver,globalPage.getMessageSubscription());
            }
            System.out.println("Trials for unique emails: " + trials);
            Assertions.assertEquals(MessageConstants.MESSAGE_FOR_SUBSCRIBE,globalPage.getMessageSubscription().getText());
        }
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
    @Test
    @Order(6)
    @DisplayName("TC-6. Sort Items by value and change order directions")
    void sortItemsByValueAndChangeOrderDirection(){
        globalPage = new GlobalPage(driver);
        itemsPage = new ItemsListPage(driver);
        itemsView = new ItemsView(driver);

        globalPage.hoverElement(globalPage.getMenuWomen());
        globalPage.waitToBeVisible(globalPage.getMenuWomenTops(), 3);
        globalPage.hoverElementClick(globalPage.getMenuWomenTops());

        // Default sorting is by Position
        itemsView.scrollToElement(itemsView.getItemAmountMessage());
        Assertions.assertTrue(itemsPage.getItemOne().getText().contains("Breathe-Easy Tank"));
        System.out.println("1 default "+ itemsPage.getItemOne().getText());

        // Sort by product name
        itemsView.clickElement(itemsView.getSelectSortBy());
        itemsView.selectByValueElement(itemsView.getSelectSortBy(), "name");
        itemsView.scrollToElement(itemsView.getItemAmountMessage());
        itemsPage.waitToBeVisible(itemsPage.getItemOne(), 5);
        Assertions.assertTrue(itemsPage.getItemOne().getText().contains("Adrienne Trek Jacket"));
        System.out.println("1 after sort "+ itemsPage.getItemOne().getText());

        // Set Descending order
        itemsView.clickElement(itemsView.getOrderFilter());
        itemsView.scrollToElement(itemsView.getItemAmountMessage());
        itemsPage.waitToBeVisible(itemsPage.getItemOne(), 5);
        Assertions.assertTrue(itemsPage.getItemOne().getText().contains("Zoe Tank"));
        System.out.println("1 descending "+ itemsPage.getItemOne().getText());

        // Set Ascending order (revert the old one)
        itemsView.clickElement(itemsView.getOrderFilter());
        itemsView.scrollToElement(itemsView.getItemAmountMessage());
        itemsPage.waitToBeVisible(itemsPage.getItemOne(), 5);
        Assertions.assertTrue(itemsPage.getItemOne().getText().contains("Adrienne Trek Jacket"));
        System.out.println("1 after revert "+ itemsPage.getItemOne().getText());
    }
    @Test
    @Order(7)
    @DisplayName("TC-7. Change items view from List to Grid ")
    void changeItemsViewToFromGridToList(){
        globalPage = new GlobalPage(driver);
        itemsPage = new ItemsListPage(driver);
        itemsView = new ItemsView(driver);

        globalPage.hoverElement(globalPage.getMenuWomen());
        globalPage.waitToBeVisible(globalPage.getMenuWomenTops(), 3);
        globalPage.hoverElement(globalPage.getMenuWomenTops());
        globalPage.waitToBeVisible(globalPage.getMenuWomenTopsJackets(), 3);
        globalPage.hoverElementClick(globalPage.getMenuWomenTopsJackets());

        // Check for amount of items on page ( by default is Grid )
        itemsView.scrollToElement(itemsView.getItemAmountMessage());
        System.out.println(itemsView.getItemAmountMessage().getText());
        String defaultAmount = itemsView.getItemAmountMessage().getText();
        Assertions.assertEquals(defaultAmount,"12 Items");
        itemsPage.scrollToElement(itemsPage.getItemOne());
        Assertions.assertTrue(itemsPage.getItemOne().getText().contains("Olivia 1/4 Zip Light Jacket"));
        itemsPage.scrollToElement(itemsPage.getItemTwelve());
        Assertions.assertTrue(itemsPage.getItemTwelve().getText().contains("Stellar Solar Jacket"));

        // Change view to List
        itemsView.clickElement(itemsView.getListView());
        itemsPage.scrollToElement(itemsPage.getItemOne());
        String defaultListAmount = itemsView.getItemAmountMessage().getText();
        Assertions.assertTrue(defaultListAmount.contains("10"));
        System.out.println(itemsView.getItemAmountMessage().getText());
        itemsPage.scrollToElement(itemsPage.getItemTen());
        Assertions.assertEquals("Augusta Pullover Jacket",itemsPage.getItemTen().getText());
    }
    @Test
    @Order(8)
    @DisplayName("TC-8.  ")
    void verifyFooterLinks(){
        globalPage = new GlobalPage(driver);
        globalPage.scrollEndPage();
        String headerAboutUs = "About us";
        String hostedBy = "This site is hosted by";

        globalPage.getFooterLinks(globalPage.getItemFromUnorderedList(globalPage.getFooterLinks(), "About us"));

        System.out.println(globalPage.getFooterLinks().getText());
        globalPage.waitForVisibilityOf(headerAboutUs,5);
        globalPage.waitForVisibilityOf(hostedBy,5);

        Assertions.assertTrue(driver.getCurrentUrl().contains(UrlConstants.ABOUT_US_URL));
        Assertions.assertTrue(globalPage.getAboutUsPageText().getText().contains(headerAboutUs));
        Assertions.assertTrue(globalPage.getAboutUsPageText().getText().contains(hostedBy));
    }


}
