package loginTests;

import ReportUtils.ListenerTest;
import base.BaseTest;
import base.Constants;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import Pages.AccountPage;
import Pages.HomePage;
import Pages.LoginPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(ListenerTest.class)
public class LoginTests extends BaseTest {
    HomePage homePage;
    AccountPage accountPage;
    LoginPage loginPage;

    @Test
    @Order(1)
    @DisplayName("TC-1. Login with valid username and password")
    void userCanLoginWithValidUsernameAndPassword() {

        homePage = new HomePage(driver);
        homePage.clickHeaderSignInButton();
        loginPage = new LoginPage(driver);
        loginPage.enterValidEmail();
        loginPage.enterValidPassword();
        loginPage.clickSignInButton();
        homePage.pauseSeconds(2);
        homePage.clickHeaderDropdownAccountButton();
        homePage.pauseSeconds(1);
        homePage.clickHeaderDropdownMyAccount();
        homePage.pauseSeconds(1);
        accountPage = new AccountPage(driver);
        highLightElement(driver, accountPage.myAccountTextHeader);
        homePage.pauseSeconds(1);

        Assertions.assertEquals(Constants.MY_ACCOUNT, accountPage.myAccountTextHeader.getText());
        highLightElement(driver, accountPage.accountInfoText);
        Assertions.assertEquals(Constants.ACCOUNT_INFORMATION, accountPage.accountInfoText.getText());
        highLightElement(driver, accountPage.accountContactInfoText);
        Assertions.assertEquals(Constants.ACCOUNT_CONTACT_INFORMATION, accountPage.accountContactInfoText.getText());
        highLightElement(driver, accountPage.accountNewslettersText);
        Assertions.assertEquals(Constants.ACCOUNT_NEWSLETTERS_INFORMATION, accountPage.accountNewslettersText.getText());
        highLightElement(driver, accountPage.userNameInfo);
        Assertions.assertEquals("Miso Misov\nmislead4@mail.bg", accountPage.userNameInfo.getText());
        highLightElement(driver, accountPage.addressBookInfo);
        Assertions.assertEquals(Constants.ADDRESS_BOOK, accountPage.addressBookInfo.getText());
        highLightElement(driver, accountPage.defaultBillingAddress);
        Assertions.assertEquals(Constants.ADDRESS_BOOK_DEFAULT_BILLING_ADDRESS, accountPage.defaultBillingAddress.getText());
        highLightElement(driver, accountPage.defaultBillingAddress);
        Assertions.assertEquals(Constants.ADDRESS_BOOK_DEFAULT_SHIPPING_ADDRESS, accountPage.defaultShippingAddress.getText());

    }

    @Test
    @Order(2)
    @DisplayName("TC-1.1 Login with valid credentials and Logout")
    void userCanLoginAndLogout() {

        homePage = new HomePage(driver);
        homePage.clickHeaderSignInButton();
        loginPage = new LoginPage(driver);
        loginPage.enterValidEmail();
        loginPage.enterValidPassword();
        loginPage.clickSignInButton();
        homePage.pauseSeconds(2);
        homePage.clickHeaderDropdownAccountButton();
        homePage.pauseSeconds(1);
        homePage.clickHeaderDropdownMyAccount();
        homePage.pauseSeconds(1);
        accountPage = new AccountPage(driver);
        highLightElement(driver, accountPage.myAccountTextHeader);
        homePage.pauseSeconds(1);

        Assertions.assertEquals(Constants.MY_ACCOUNT, accountPage.myAccountTextHeader.getText());
        Assertions.assertEquals(Constants.ACCOUNT_INFORMATION, accountPage.accountInfoText.getText());
        Assertions.assertEquals(Constants.ACCOUNT_CONTACT_INFORMATION, accountPage.accountContactInfoText.getText());
        Assertions.assertEquals(Constants.ACCOUNT_NEWSLETTERS_INFORMATION, accountPage.accountNewslettersText.getText());
        Assertions.assertEquals("Miso Misov\nmislead4@mail.bg", accountPage.userNameInfo.getText());
        Assertions.assertEquals(Constants.ADDRESS_BOOK, accountPage.addressBookInfo.getText());
        Assertions.assertEquals(Constants.ADDRESS_BOOK_DEFAULT_BILLING_ADDRESS, accountPage.defaultBillingAddress.getText());
        Assertions.assertEquals(Constants.ADDRESS_BOOK_DEFAULT_SHIPPING_ADDRESS, accountPage.defaultShippingAddress.getText());

        homePage.clickHeaderDropdownAccountButton();
        homePage.pauseSeconds(1);
        homePage.clickDropdownSignOut();
        homePage.pauseSeconds(1);
        Assertions.assertEquals(Constants.SIGN_OUT_SUCCESS_MESSAGE, loginPage.signOutMessageHeader.getText());
        Assertions.assertEquals(Constants.SIGN_OUT_SUCCESS_MESSAGE_PARAGRAPH, loginPage.signOutMessageParagraph.getText());
        homePage.waitToBeInvisible(loginPage.signOutMessageParagraph, 6);
    }

    /**
     * All tests from order 3 to 5 include are hidden, because the site uses custom captcha method, that is not handle by those scripts.
     * You can test it each of them after the user is correctly logged after capture is show up.
     */
//    @Test
//    @Order(3)
//    @DisplayName("TC-2. Cannot log in with valid username and incorrect password")
//    void userCannotLoginWithValidUsernameAndIncorrectPassword(){
//
//        homePage = new HomePage(driver);
//        homePage.clickHeaderSignInButton();
//        loginPage = new LoginPage(driver);
//        loginPage.enterValidEmail();
//        loginPage.enterInvalidPassword();
//        loginPage.clickSignInButton();
//        homePage.waitToBeVisible(loginPage.errorMessage, 5);
//        Assertions.assertEquals(Constants.ERROR_MESSAGE_FOR_LOGIN,loginPage.errorMessage.getText());
//    }
//    @Test
//    @Order(4)
//    @DisplayName("TC-3. Cannot log in with invalid username and correct password")
//    void userCannotLoginWithInvalidUsernameAndCorrectPassword(){
//
//        homePage = new HomePage(driver);
//        homePage.clickHeaderSignInButton();
//        loginPage = new LoginPage(driver);
//        loginPage.enterInvalidEmail();
//        loginPage.enterValidPassword();
//        loginPage.clickSignInButton();
//        homePage.waitToBeVisible(loginPage.errorMessage, 5);
//        String incorrectCaptcha = "Incorrect CAPTCHA";
//        if (loginPage.errorMessage.getText().equals(incorrectCaptcha)  ){
//            Assertions.assertEquals(incorrectCaptcha,loginPage.errorMessage.getText());
//            System.out.println("Captcha is displayed!");
//        }else {
//            Assertions.assertEquals(Constants.ERROR_MESSAGE_FOR_LOGIN,loginPage.errorMessage.getText());
//        }
//
//    }
//    @Test
//    @Order(5)
//    @DisplayName("TC-4. Cannot log in with invalid username and invalid password")
//    void userCannotLoginWithInvalidUsernameAndInvalidPassword(){
//
//        homePage = new HomePage(driver);
//        homePage.clickHeaderSignInButton();
//        loginPage = new LoginPage(driver);
//        loginPage.enterInvalidEmail();
//        loginPage.enterInvalidPassword();
//        loginPage.clickSignInButton();
//        homePage.waitToBeVisible(loginPage.errorMessage, 5);
//        String incorrectCaptcha = "Incorrect CAPTCHA";
//        if (loginPage.errorMessage.getText().equals(incorrectCaptcha)  ){
//            Assertions.assertEquals(incorrectCaptcha,loginPage.errorMessage.getText());
//            System.out.println("Captcha is displayed!");
//        }else {
//            Assertions.assertEquals(Constants.ERROR_MESSAGE_FOR_LOGIN,loginPage.errorMessage.getText());
//        }
//    }
    @Test
    @Order(6)
    @DisplayName("TC-5. Cannot login with empty username and empty password")
    void userCannotLoginWithEmptyUsernameAndEmptyPassword() {

        homePage = new HomePage(driver);
        homePage.clickHeaderSignInButton();
        loginPage = new LoginPage(driver);
        loginPage.enterEmptyEmail();
        loginPage.enterEmptyPassword();
        loginPage.clickSignInButton();
        String errorMessageRequired = "This is a required field.";
        Assertions.assertEquals(errorMessageRequired, loginPage.emailRequired.getText());
        Assertions.assertEquals(errorMessageRequired, loginPage.passwordRequired.getText());

    }

    @Test
    @Order(7)
    @DisplayName("TC-6. Cannot login with empty username and correct password")
    void userCannotLoginWithEmptyUsernameAndCorrectPassword() {

        homePage = new HomePage(driver);
        homePage.clickHeaderSignInButton();
        loginPage = new LoginPage(driver);
        loginPage.enterEmptyEmail();
        loginPage.enterValidPassword();
        loginPage.clickSignInButton();
        String errorMessageRequired = "This is a required field.";
        Assertions.assertEquals(errorMessageRequired, loginPage.emailRequired.getText());
    }

    @Test
    @Order(8)
    @DisplayName("TC-7. Cannot login with username and empty password")
    void userCannotLoginWithUsernameAndEmptyPassword() {

        homePage = new HomePage(driver);
        homePage.clickHeaderSignInButton();
        loginPage = new LoginPage(driver);
        loginPage.enterValidEmail();
        loginPage.enterEmptyPassword();
        loginPage.clickSignInButton();
        String errorMessageRequired = "This is a required field.";
        Assertions.assertEquals(errorMessageRequired, loginPage.passwordRequired.getText());
    }
}
