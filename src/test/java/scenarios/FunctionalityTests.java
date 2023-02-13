package scenarios;

import constants.UrlConstants;
import itemsUtils.ItemsListPage;
import base.BaseTest;
import constants.MessageConstants;
import itemsUtils.ItemsSearchPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.AboutUsPage;
import pages.CustomerServicePage;
import reports.WatcherTest;
import faker.FakeData;
import utils.GlobalElements;
import itemsUtils.ItemsView;
import itemsUtils.ItemDetailsPage;
import utils.ShoppingOptions;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(WatcherTest.class)
public class FunctionalityTests extends BaseTest{
    GlobalElements globalElements;
    FakeData fakeData;
    ItemsListPage itemsPage;
    ItemsView itemsView;
    ItemDetailsPage itemDetailsPage;
    ItemsSearchPage itemsSearchPage;
    AboutUsPage aboutUsPage;
    CustomerServicePage customerServicePage;
    ShoppingOptions  shoppingOptions;

    @Test
    @DisplayName("TC-1. Search items with valid data by color")
    @Order(1)
    void searchItemsWithValidDataByColor(){
        //Initialize objects from classes
        globalElements = new GlobalElements(driver);
        itemDetailsPage = new ItemDetailsPage(driver);
        itemsSearchPage = new ItemsSearchPage(driver);

        // Typing valid data in the search input bar
        globalElements.setText(globalElements.getSearchInputField(), "Blue");
        globalElements.pressEnter(globalElements.getSearchInputField());
        // Scroll to the found elements and check if its exists and color blue options is displayed
        itemsSearchPage.scrollToElement(itemsSearchPage.getItemOne());
        itemsSearchPage.hoverElement(itemsSearchPage.getItemOne());
        itemsSearchPage.pauseSeconds(2);
        String itemNameChloe = "Chloe Compete Tank";
        Assertions.assertTrue(itemsSearchPage.getItemOne().getText().contains(itemNameChloe));
        itemDetailsPage.getColorBlue().click();
        Assertions.assertTrue(itemDetailsPage.getColorBlue().isDisplayed());
        itemsSearchPage.scrollToElement(itemsSearchPage.getItemThree());
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
        globalElements = new GlobalElements(driver);
        itemsView = new ItemsView(driver);
        // Typing valid data in the search input bar
        globalElements.setText(globalElements.getSearchInputField(), "jhsddhjgh");
        globalElements.pressEnter(globalElements.getSearchInputField());
        globalElements.waitToBeVisible(itemsView.getNoResults(), 3);
        Assertions.assertEquals(MessageConstants.MESSAGE_NO_RESULT,itemsView.getNoResults().getText());
    }
    @Test
    @DisplayName("TC-3. Get correct URL from each page")
    @Order(3)
    void getUrlFromDifferentPages(){
        globalElements = new GlobalElements(driver);
        itemsPage = new ItemsListPage(driver);

        String baseUrl = "https://magento.softwaretestingboard.com/";
        Assertions.assertEquals(baseUrl,driver.getCurrentUrl());
        String menuWomenUrl = "https://magento.softwaretestingboard.com/women.html";
        globalElements.clickElement(globalElements.getMenuWomen());
        Assertions.assertEquals(menuWomenUrl,driver.getCurrentUrl());
        globalElements.hoverElement(globalElements.getMenuWomen());
        globalElements.waitToBeVisible(globalElements.getMenuWomenTops(), 5);
        globalElements.hoverElementClick(globalElements.getMenuWomenTops());
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
        globalElements = new GlobalElements(driver);
        fakeData = new FakeData();
        globalElements.scrollToElement(globalElements.getNewsLetterField());
        globalElements.setText(globalElements.getNewsLetterField(), fakeData.getEmailAddress());
        globalElements.clickElement(globalElements.getSubscribeButton());
        globalElements.pauseSeconds(1);
        globalElements.waitToBeVisible(globalElements.getMessageSubscription(), 3);
        int trials = 0;
        if(globalElements.getMessageSubscription().getText().equals(MessageConstants.MESSAGE_FOR_SUBSCRIBE)){
            Assertions.assertEquals(MessageConstants.MESSAGE_FOR_SUBSCRIBE, globalElements.getMessageSubscription().getText());
        } else if (globalElements.getMessageSubscription().getText().equals(MessageConstants.MESSAGE_INVALID_SUBSCRIBE)) {
            Assertions.assertEquals(MessageConstants.MESSAGE_INVALID_SUBSCRIBE, globalElements.getMessageSubscription().getText());
            System.out.println("Form Invalid key message!");
        } else {
            while(globalElements.getMessageSubscription().getText().equals(MessageConstants.MESSAGE_ALREADY_SUBSCRIBED)){
                trials +=1;
                globalElements.scrollToElement(globalElements.getNewsLetterField());
                globalElements.setText(globalElements.getNewsLetterField(), fakeData.getEmailAddress());
                globalElements.clickElement(globalElements.getSubscribeButton());
                globalElements.pauseSeconds(1);
                globalElements.waitToBeVisible(globalElements.getMessageSubscription(), 3);
            }
            System.out.println("Trials for unique emails: " + trials);
            Assertions.assertEquals(MessageConstants.MESSAGE_FOR_SUBSCRIBE, globalElements.getMessageSubscription().getText());
        }
    }
    @Test
    @DisplayName("TC-5. Subscribe to a newsletter with a user who has already subscribed")
    @Order(5)
    void subscribesForNewsletterWithAlreadySubscribedEmail(){
        globalElements = new GlobalElements(driver);
        globalElements.scrollToElement(globalElements.getNewsLetterField());
        globalElements.setText(globalElements.getNewsLetterField(), "mislead4@mail.bg");
        globalElements.clickElement(globalElements.getSubscribeButton());
        globalElements.pauseSeconds(1);
        globalElements.waitToBeVisible(globalElements.getMessageSubscription(), 3);
        if (globalElements.getMessageSubscription().getText().equals(MessageConstants.MESSAGE_ALREADY_SUBSCRIBED)) {
            Assertions.assertEquals(MessageConstants.MESSAGE_ALREADY_SUBSCRIBED, globalElements.getMessageSubscription().getText());
            System.out.println("Correct message!");
        } else {
            Assertions.assertEquals(MessageConstants.MESSAGE_INVALID_SUBSCRIBE, globalElements.getMessageSubscription().getText());
            System.out.println("Form Invalid key message!");
        }
    }
    @Test
    @Order(6)
    @DisplayName("TC-6. Sort Items by value and change order directions")
    void sortItemsByValueAndChangeOrderDirection(){
        globalElements = new GlobalElements(driver);
        itemsPage = new ItemsListPage(driver);
        itemsView = new ItemsView(driver);

        globalElements.hoverElement(globalElements.getMenuWomen());
        globalElements.waitToBeVisible(globalElements.getMenuWomenTops(), 3);
        globalElements.hoverElementClick(globalElements.getMenuWomenTops());

        // Default sorting is by Position
        itemsView.scrollToElement(itemsView.getItemViewAmountText());
        Assertions.assertTrue(itemsPage.getItemOne().getText().contains("Breathe-Easy Tank"));
        System.out.println("1 default "+ itemsPage.getItemOne().getText());

        // Sort by product name
        itemsView.clickElement(itemsView.getSelectSortBy());
        itemsView.selectByValueElement(itemsView.getSelectSortBy(), "name");
        itemsView.scrollToElement(itemsView.getItemViewAmountText());
        itemsPage.waitToBeVisible(itemsPage.getItemOne(), 5);
        Assertions.assertTrue(itemsPage.getItemOne().getText().contains("Adrienne Trek Jacket"));
        System.out.println("1 after sort "+ itemsPage.getItemOne().getText());

        // Set Descending order
        itemsView.clickElement(itemsView.getOrderFilter());
        itemsView.scrollToElement(itemsView.getItemViewAmountText());
        itemsPage.waitToBeVisible(itemsPage.getItemOne(), 5);
        Assertions.assertTrue(itemsPage.getItemOne().getText().contains("Zoe Tank"));
        System.out.println("1 descending "+ itemsPage.getItemOne().getText());

        // Set Ascending order (revert the old one)
        itemsView.clickElement(itemsView.getOrderFilter());
        itemsView.scrollToElement(itemsView.getItemViewAmountText());
        itemsPage.waitToBeVisible(itemsPage.getItemOne(), 5);
        Assertions.assertTrue(itemsPage.getItemOne().getText().contains("Adrienne Trek Jacket"));
        System.out.println("1 after revert "+ itemsPage.getItemOne().getText());
    }
    @Test
    @Order(7)
    @DisplayName("TC-7. Change items view from List to Grid ")
    void changeItemsViewToFromGridToList(){
        globalElements = new GlobalElements(driver);
        itemsPage = new ItemsListPage(driver);
        itemsView = new ItemsView(driver);

        globalElements.hoverElement(globalElements.getMenuWomen());
        globalElements.waitToBeVisible(globalElements.getMenuWomenTops(), 3);
        globalElements.hoverElement(globalElements.getMenuWomenTops());
        globalElements.waitToBeVisible(globalElements.getMenuWomenTopsJackets(), 3);
        globalElements.hoverElementClick(globalElements.getMenuWomenTopsJackets());

        // Check for amount of items on page ( by default is Grid )
        itemsView.scrollToElement(itemsView.getItemViewAmountText());
        System.out.println(itemsView.getItemViewAmountText().getText());
        String defaultAmount = itemsView.getItemViewAmountText().getText();
        Assertions.assertEquals(defaultAmount,"12 Items");
        itemsPage.scrollToElement(itemsPage.getItemOne());
        Assertions.assertTrue(itemsPage.getItemOne().getText().contains("Olivia 1/4 Zip Light Jacket"));
        itemsPage.scrollToElement(itemsPage.getItemTwelve());
        Assertions.assertTrue(itemsPage.getItemTwelve().getText().contains("Stellar Solar Jacket"));

        // Change view to List
        itemsView.clickElement(itemsView.getListView());
        itemsPage.scrollToElement(itemsPage.getItemOne());
        String defaultListAmount = itemsView.getItemViewAmountText().getText();
        Assertions.assertTrue(defaultListAmount.contains("10"));
        System.out.println(itemsView.getItemViewAmountText().getText());
        itemsPage.scrollToElement(itemsPage.getItemTen());
        Assertions.assertEquals("Augusta Pullover Jacket",itemsPage.getItemTen().getText());
    }
    @Test
    @Order(8)
    @DisplayName("TC-8. Verify Footer links")
    void verifyFooterLinks(){
        globalElements = new GlobalElements(driver);
        aboutUsPage = new AboutUsPage(driver);
        customerServicePage = new CustomerServicePage(driver);

        // Scroll to the end
        globalElements.scrollEndPage();

        // About us link and information
        String aboutUsHeading = "About us";
        String hostedByParagraph = "This site is hosted by";
        String coursesParagraph = "Bundle Course (100x value)";
        globalElements.clickElement(globalElements.getFooterAboutUsLink());
        Assertions.assertTrue(driver.getCurrentUrl().contains(UrlConstants.ABOUT_US_URL));
        aboutUsPage.pauseSeconds(2);
        aboutUsPage.highLightElement(aboutUsPage.getAboutUsHeader());
        Assertions.assertTrue(aboutUsPage.getAboutUsHeader().getText().contains(aboutUsHeading));
        aboutUsPage.highLightElement(aboutUsPage.getAboutUsHostedBy());
        Assertions.assertTrue(aboutUsPage.getAboutUsHostedBy().getText().contains(hostedByParagraph));
        aboutUsPage.highLightElement(aboutUsPage.getAboutUsCourse());
        Assertions.assertTrue(aboutUsPage.getAboutUsCourse().getText().contains(coursesParagraph));
        aboutUsPage.pauseSeconds(2);
        driver.navigate().back();
        // Customer service link
        String customerServiceHeading = "Customer Service";
        String shippingHeading = "Shipping and Delivery";
        String returnsHeading = "Returns and Replacements";
        globalElements.scrollEndPage();
        globalElements.clickElement(globalElements.getFooterCustomerServiceLink());
        Assertions.assertTrue(driver.getCurrentUrl().contains(UrlConstants.CUSTOMER_SERVICE_URL));
        aboutUsPage.pauseSeconds(2);
        customerServicePage.highLightElement(customerServicePage.getCustomerServiceHeaderInfo());
        Assertions.assertTrue(customerServicePage.getCustomerServiceHeaderInfo().getText().contains(customerServiceHeading));
        customerServicePage.highLightElement(customerServicePage.getCustomerServiceShippingInfo());
        Assertions.assertTrue(customerServicePage.getCustomerServiceShippingInfo().getText().contains(shippingHeading));
        customerServicePage.scrollToElement(customerServicePage.getCustomerServiceReturnsInfo());
        customerServicePage.highLightElement(customerServicePage.getCustomerServiceReturnsInfo());
        Assertions.assertTrue(customerServicePage.getCustomerServiceReturnsInfo().getText().contains(returnsHeading));

    }

    @Test
    @Order(9)
    @DisplayName("TC-9. Set shopping options")
    void setShoppingOptionsAndPurchaseProduct(){
        globalElements = new GlobalElements(driver);
        itemsView = new ItemsView(driver);
        shoppingOptions = new ShoppingOptions(driver);

        // Navigate to Women->Tops
        globalElements.hoverElement(globalElements.getMenuWomen());
        globalElements.waitToBeVisible(globalElements.getMenuWomenTops(), 3);
        globalElements.hoverElementClick(globalElements.getMenuWomenTops());
        // Assert for results and correct url
        Assertions.assertTrue(itemsView.getItemViewAmountText().getText().contains("Items 1-12 of 50"));
        Assertions.assertTrue(driver.getCurrentUrl().contains(UrlConstants.WOMEN_MENU_TOPS));
        // Click category options and choose jackets
        shoppingOptions.clickElement(shoppingOptions.getCategoryOption());
        shoppingOptions.clickListElement(shoppingOptions.getCategoryList(), "Jackets");
        // Assert after filter
        Assertions.assertTrue(itemsView.getItemViewAmountText().getText().contains("12 Items"));
        shoppingOptions.scrollToElement(shoppingOptions.getClimateOption());
        // Click Climate options and choose cold
        shoppingOptions.clickElement(shoppingOptions.getClimateOption());
        shoppingOptions.clickListElement(shoppingOptions.getClimateOptionList(), "Cold");
        shoppingOptions.pauseSeconds(2);
        // Assert both filters
        Assertions.assertTrue(itemsView.getItemViewAmountText().getText().contains("2 Items"));
        shoppingOptions.clickElement(shoppingOptions.getClimateOptionRemoveButton());
        Assertions.assertTrue(itemsView.getItemViewAmountText().getText().contains("12 Items"));
        shoppingOptions.clickElement(shoppingOptions.getClearAllButton());
        shoppingOptions.waitToBeVisible(itemsView.getItemViewAmountText(),10);
        Assertions.assertTrue(itemsView.getItemViewAmountText().getText().contains("Items 1-12 of 50"));

    }
}
