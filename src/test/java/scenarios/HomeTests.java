package scenarios;

import pages.HomePage;
import reports.ListenerTest;
import base.BaseTest;
import utils.FakeData;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(ListenerTest.class)
public class HomeTests extends BaseTest {
    HomePage homePage;
    FakeData fakeData;

//
//    @Test
//    @Order(3)
//    @DisplayName("TC-3. Subscribe to a newsletter with a user who has already subscribed")
//    void subscribesForNewsletterWithAlreadySubscribed() {
//        homePage = new HomePage(driver);
//        homePage.scrollToElement(homePage.newsLetterField);
//        homePage.newsLetterField.sendKeys("mislead4@mail.bg");
//        homePage.clickFooterSubscribeButton();
//        homePage.pauseSeconds(1);
//        homePage.waitToBeVisible(homePage.messageForSubscription, 2);
//        highLightElement(driver, homePage.messageForSubscription);
//        if (homePage.messageForSubscription.getText().equals(GlobalConstants.MESSAGE_ALREADY_HAVE_SUBSCRIPTION)) {
//            Assertions.assertEquals(GlobalConstants.MESSAGE_ALREADY_HAVE_SUBSCRIPTION, homePage.messageForSubscription.getText());
//            System.out.println("Correct message!");
//        } else {
//            Assertions.assertEquals("Invalid Form Key. Please refresh the page.", homePage.messageForSubscription.getText());
//            System.out.println("Form Invalid key message!");
//        }
//    }
//
//    @Test
//    @Order(4)
//    @DisplayName("TC-4. Subscribe to a newsletter for new user")
//    void subscribesNewsletterForNewUser() {
//        homePage = new HomePage(driver);
//        homePage.scrollToElement(homePage.newsLetterField);
//        fakeData = new FakeData();
//        homePage.newsLetterField.sendKeys(fakeData.emailAddress);
//        homePage.clickFooterSubscribeButton();
//        homePage.pauseSeconds(1);
//        homePage.waitToBeVisible(homePage.messageForSubscription, 2);
//        highLightElement(driver, homePage.messageForSubscription);
//        int tries = 0;
//        if (homePage.messageForSubscription.getText().equals(GlobalConstants.MESSAGE_AFTER_SUBSCRIPTION)) {
//            Assertions.assertEquals(GlobalConstants.MESSAGE_AFTER_SUBSCRIPTION, homePage.messageForSubscription.getText());
//        } else {
//            while (homePage.messageForSubscription.getText().equals(GlobalConstants.MESSAGE_ALREADY_HAVE_SUBSCRIPTION)) {
//                tries += 1;
//                homePage.scrollToElement(homePage.newsLetterField);
//                homePage.newsLetterField.sendKeys(fakeData.emailAddress);
//                homePage.clickFooterSubscribeButton();
//                homePage.pauseSeconds(1);
//                homePage.waitToBeVisible(homePage.messageForSubscription, 2);
//                highLightElement(driver, homePage.messageForSubscription);
//            }
//        }
//        System.out.println("Tries: " + tries);
//        Assertions.assertEquals(GlobalConstants.MESSAGE_AFTER_SUBSCRIPTION, homePage.messageForSubscription.getText());
//    }
//
//    @Test
//    @Order(5)
//    @DisplayName("TC-5. Scrolling and identify all elements on the page")
//    void scrollingAndIdentifyElementsOnPage() {
//        homePage = new HomePage(driver);
//        homePage.scrollToElement(homePage.menuWhatsNew);
//        highLightElement(driver, homePage.menuWhatsNew);
//        homePage.pauseSeconds(1);
//        homePage.scrollToElement(homePage.newLumaYogaBanner);
//        homePage.scrollToElement(homePage.getNewLumaYogaContent);
//        highLightElement(driver, homePage.newLumaYogaBanner);
//        homePage.pauseSeconds(1);
//        homePage.scrollToElement(homePage.lumaPantsBanner);
//        homePage.scrollToElement(homePage.lumaPantsContent);
//        highLightElement(driver, homePage.lumaPantsBanner);
//        homePage.pauseSeconds(1);
//        homePage.scrollToElement(homePage.lumaTeesBanner);
//        homePage.scrollToElement(homePage.lumaTeesContent);
//        highLightElement(driver, homePage.lumaTeesBanner);
//        homePage.pauseSeconds(1);
//        homePage.scrollToElement(homePage.lumaTakeItFromErin);
//        highLightElement(driver, homePage.lumaTakeItFromErin);
//        homePage.pauseSeconds(1);
//        homePage.scrollToElement(homePage.lumaPerformanceBanner);
//        homePage.scrollToElement(homePage.lumaPerformanceContent);
//        highLightElement(driver, homePage.lumaPerformanceBanner);
//        homePage.pauseSeconds(1);
//        homePage.scrollToElement(homePage.lumaTwiceAround);
//        highLightElement(driver, homePage.lumaTwiceAround);
//        homePage.pauseSeconds(1);
//        homePage.scrollToElement(homePage.hotSellersItems);
//        homePage.pauseSeconds(1);
//        homePage.scrollEndPage();
//        String lastParagraphFooter = "Use this site to website to practice selenium.";
//        highLightElement(driver, homePage.lastParagraphFooter);
//        Assertions.assertEquals(lastParagraphFooter, homePage.lastParagraphFooter.getText());
//    }

}
