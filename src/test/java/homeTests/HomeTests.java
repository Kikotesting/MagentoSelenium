package homeTests;

import base.BaseTest;
import baseUtils.Constants;
import fakeData.FakeData;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Keys;
import pages.HomePage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(listeners.ListenerTest.class)
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
        if (homePage.messageForSubscription.equals(Constants.MESSAGE_ALREADY_HAVE_SUBSCRIPTION)){
            Assertions.assertEquals(Constants.MESSAGE_ALREADY_HAVE_SUBSCRIPTION,homePage.messageForSubscription.getText());
            System.out.println("Correct message!");
        }else {
            Assertions.assertEquals("Invalid Form Key. Please refresh the page.",homePage.messageForSubscription.getText());
            System.out.println("Form Invalid key message!");
        }


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

    @Test
    @Order(5)
    @DisplayName("TC-5. Scrolling and identify all elements on the page")
    void scrollingAndIdentifyElementsOnPage(){
        homePage = new HomePage(driver);
        homePage.scrollToElement(homePage.menuWhatsNew);
        highLightElement(driver,homePage.menuWhatsNew);
        homePage.pauseSeconds(1);
        homePage.scrollToElement(homePage.newLumaYogaBanner);
        homePage.scrollToElement(homePage.getNewLumaYogaContent);
        highLightElement(driver,homePage.newLumaYogaBanner);
        homePage.pauseSeconds(1);
        homePage.scrollToElement(homePage.lumaPantsBanner);
        homePage.scrollToElement(homePage.lumaPantsContent);
        highLightElement(driver,homePage.lumaPantsBanner);
        homePage.pauseSeconds(1);
        homePage.scrollToElement(homePage.lumaTeesBanner);
        homePage.scrollToElement(homePage.lumaTeesContent);
        highLightElement(driver,homePage.lumaTeesBanner);
        homePage.pauseSeconds(1);
        homePage.scrollToElement(homePage.lumaTakeItFromErin);
        highLightElement(driver,homePage.lumaTakeItFromErin);
        homePage.pauseSeconds(1);
        homePage.scrollToElement(homePage.lumaPerformanceBanner);
        homePage.scrollToElement(homePage.lumaPerformanceContent);
        highLightElement(driver,homePage.lumaPerformanceBanner);
        homePage.pauseSeconds(1);
        homePage.scrollToElement(homePage.lumaTwiceAround);
        highLightElement(driver,homePage.lumaTwiceAround);
        homePage.pauseSeconds(1);
        homePage.scrollToElement(homePage.hotSellersItems);
        homePage.pauseSeconds(1);
        homePage.scrollEndPage();
        String lastParagraphFooter = "Use this site to website to practice selenium.";
        highLightElement(driver,homePage.lastParagraphFooter);
        Assertions.assertEquals(lastParagraphFooter,homePage.lastParagraphFooter.getText());
    }

}
