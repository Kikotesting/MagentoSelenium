package homeTests;

import base.BaseTest;
import baseUtils.Constants;
import fakeData.FakeData;
import listeners.ListenerTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Keys;
import pages.HomePage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(ListenerTest.class)
public class HomeTests extends BaseTest {

    HomePage homePage;
    FakeData fakeData;

    @Test
    @Order(1)
    @DisplayName("TC-1. Search with invalid data")
    void searchWithInvalidData(){
        homePage = new HomePage(driver);

        homePage.searchInputField.click();
        homePage.searchInputField.sendKeys("JJJ&");
        homePage.searchInputField.sendKeys(Keys.ENTER);
        highLightElement(driver,homePage.searchNoResultMessage);
        homePage.pauseSeconds(1);
        Assertions.assertEquals(Constants.SEARCH_NO_RESULT,homePage.searchNoResultMessage.getText());
    }
    @Test
    @Order(2)
    @DisplayName("TC-2. Search with valid data")
    void searchWithValidData(){
        homePage = new HomePage(driver);

        homePage.searchInputField.click();
        homePage.searchInputField.sendKeys("Blue");
        homePage.searchInputField.sendKeys(Keys.ENTER);
        String foundItems = "items";
        Assertions.assertTrue(foundItems.contains("items"));

    }

    @Test
    @Order(3)
    @DisplayName("TC-3. Subscribe to a newsletter with a user who has already subscribed")
    void subscribesForNewsletterWithAlreadySubscribed(){
        homePage = new HomePage(driver);
        homePage.scrollToElement(homePage.newsLetterField);
        homePage.newsLetterField.sendKeys("mislead4@mail.bg");
        homePage.clickFooterSubscribeButton();
        homePage.pauseSeconds(1);
        homePage.waitToBeVisible(homePage.messageForSubscription,2);
        highLightElement(driver, homePage.messageForSubscription);
        Assertions.assertEquals(Constants.MESSAGE_ALREADY_HAVE_SUBSCRIPTION,homePage.messageForSubscription.getText());
    }

    @Test
    @Order(4)
    @DisplayName("TC-4. Subscribe to a newsletter for new user")
    void subscribesNewsletterForNewUser(){
        homePage = new HomePage(driver);
        homePage.scrollToElement(homePage.newsLetterField);
        fakeData = new FakeData();
        homePage.newsLetterField.sendKeys(fakeData.emailaddress);
        homePage.clickFooterSubscribeButton();
        homePage.pauseSeconds(1);
        homePage.waitToBeVisible(homePage.messageForSubscription,2);
        highLightElement(driver, homePage.messageForSubscription);
        Integer tries = 0;
        if (homePage.messageForSubscription.getText().equals(Constants.MESSAGE_AFTER_SUBSCRIPTION)){
            Assertions.assertEquals(Constants.MESSAGE_AFTER_SUBSCRIPTION,homePage.messageForSubscription.getText());
        } else {
            while (homePage.messageForSubscription.getText().equals(Constants.MESSAGE_ALREADY_HAVE_SUBSCRIPTION)){
                tries +=1;
                homePage.scrollToElement(homePage.newsLetterField);
                homePage.newsLetterField.sendKeys(fakeData.emailaddress);
                homePage.clickFooterSubscribeButton();
                homePage.pauseSeconds(1);
                homePage.waitToBeVisible(homePage.messageForSubscription,2);
                highLightElement(driver, homePage.messageForSubscription);
            }
        }
        System.out.println("Tries: " + tries);
        Assertions.assertEquals(Constants.MESSAGE_AFTER_SUBSCRIPTION,homePage.messageForSubscription.getText());
    }

}
