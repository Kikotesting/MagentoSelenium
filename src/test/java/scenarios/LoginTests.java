package scenarios;

import constants.MessageConstants;
import pages.LoginPage;
import pages.SignOutPage;
import reports.ListenerTest;
import base.BaseTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.GlobalPage;
import utils.RegisteredUser;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(ListenerTest.class)
public class LoginTests extends BaseTest {

    GlobalPage globalPage;
    LoginPage loginPage;
    RegisteredUser registeredUser;
    SignOutPage signOutPage;

    @Test
    @Order(1)
    @DisplayName("TC-1. Login with valid username and password")
    void userCanLoginWithValidUsernameAndPassword(){
        globalPage = new GlobalPage(driver);
        loginPage = new LoginPage(driver);

        globalPage.clickElement(globalPage.getSignInTextButton());
        highLightElement(driver, loginPage.getWelcomeDefaultMessage());
        globalPage.waitToBeVisible(loginPage.getWelcomeDefaultMessage(),5);
        Assertions.assertTrue(loginPage.getWelcomeDefaultMessage().getText().toLowerCase().toString().contains("welcome msg!"));
        loginPage.enterValidEmail();
        loginPage.enterValidPassword();
        loginPage.clickSignInButton();
        loginPage.waitToBeVisible(loginPage.getWelcomeLoggedInMessage(), 5);
        highLightElement(driver, loginPage.getWelcomeLoggedInMessage());
        Assertions.assertTrue(loginPage.getWelcomeLoggedInMessage().getText().toString().contains("Miso Misov!"));
    }
    @Test
    @Order(2)
    @DisplayName("TC-2. Login with valid username and password and Log out")
    void userCanLoginWithValidUsernameAndPasswordAndLogOut(){
        globalPage = new GlobalPage(driver);
        loginPage = new LoginPage(driver);
        registeredUser = new RegisteredUser(driver);
        signOutPage = new SignOutPage(driver);

        globalPage.clickElement(globalPage.getSignInTextButton());
        loginPage.defaultLogin();
        loginPage.waitToBeVisible(loginPage.getWelcomeLoggedInMessage(), 5);
        loginPage.pauseSeconds(2);
        highLightElement(driver, loginPage.getWelcomeLoggedInMessage());
        Assertions.assertTrue(loginPage.getWelcomeLoggedInMessage().getText().toString().contains("Miso Misov!"));
        registeredUser.clickElement(registeredUser.getDropdownMenu());
        registeredUser.waitToBeVisible(registeredUser.getDropdownSignOut(), 5);
        registeredUser.waitToBeClickable(registeredUser.getDropdownSignOut(), 5);
        registeredUser.pauseSeconds(2);
        registeredUser.clickElement(registeredUser.getDropdownSignOut());
        Assertions.assertEquals(MessageConstants.MESSAGE_SIGN_OUT_SUCCESS_HEADER,signOutPage.getSignOutMessageHeader().getText());
        Assertions.assertEquals(MessageConstants.MESSAGE_SIGN_OUT_SUCCESS_PARAGRAPH,signOutPage.getSignOutMessageParagraph().getText());
        String signOutUrl = driver.getCurrentUrl();
        System.out.println(signOutUrl);
        Assertions.assertTrue(driver.getCurrentUrl().contains(signOutUrl));
        signOutPage.pauseSeconds(6);
        Assertions.assertTrue(driver.getCurrentUrl().contains(MessageConstants.BASE_URL));
    }
    @Test
    @Order(3)
    @DisplayName("TC-3. Cannot login with valid username and empty password")
    void userCannotLoginWithValidUsernameAndEmptyPassword() {
        globalPage = new GlobalPage(driver);
        loginPage = new LoginPage(driver);
        globalPage.clickElement(globalPage.getSignInTextButton());
        loginPage.enterValidEmail();
        loginPage.enterEmptyPassword();
        loginPage.clickSignInButton();
        String errorMessageRequired = "This is a required field.";
        Assertions.assertEquals(errorMessageRequired, loginPage.getPasswordRequired().getText());
    }
    @Test
    @Order(4)
    @DisplayName("TC-4. Cannot login with empty username and valid password")
    void userCannotLoginWithEmptyUsernameAndValidPassword() {
        globalPage = new GlobalPage(driver);
        loginPage = new LoginPage(driver);
        globalPage.clickElement(globalPage.getSignInTextButton());
        loginPage.enterEmptyEmail();
        loginPage.enterValidPassword();
        loginPage.clickSignInButton();
        String errorMessageRequired = "This is a required field.";
        Assertions.assertEquals(errorMessageRequired, loginPage.getEmailRequired().getText());
    }
    @Test
    @Order(5)
    @DisplayName("TC-5. Cannot login with empty username and empty password")
    void userCannotLoginWithEmptyUsernameAndEmptyPassword() {
        globalPage = new GlobalPage(driver);
        loginPage = new LoginPage(driver);
        globalPage.clickElement(globalPage.getSignInTextButton());
        loginPage.enterEmptyEmail();
        loginPage.enterEmptyPassword();
        loginPage.clickSignInButton();
        String errorMessageRequired = "This is a required field.";
        Assertions.assertEquals(errorMessageRequired, loginPage.getEmailRequired().getText());
        Assertions.assertEquals(errorMessageRequired, loginPage.getPasswordRequired().getText());
    }
    @Test
    @Order(6)
    @DisplayName("TC-6. Cannot login with Invalid username")
    void userCannotLoginWithInvalidUsername() {
        globalPage = new GlobalPage(driver);
        loginPage = new LoginPage(driver);
        globalPage.clickElement(globalPage.getSignInTextButton());
        loginPage.enterInvalidEmail();
        loginPage.clickSignInButton();
        String errorMessageRequired = "Please enter a valid email address (Ex: johndoe@domain.com).";
        Assertions.assertEquals(errorMessageRequired, loginPage.getEmailRequired().getText());
    }

//    /**
//     * All tests from order 3 to 5 include are hidden, because the site uses custom captcha method, that is not handle by those scripts.
//     * You can test it each of them after the user is correctly logged after capture is show up.
//     */
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
//        String incorrectCaptcha = "Incorrect CAPTCHA";
//        if (loginPage.errorMessage.getText().equals(incorrectCaptcha)  ){
//            Assertions.assertEquals(incorrectCaptcha,loginPage.errorMessage.getText()+" FAILED");
//            System.out.println("Captcha is displayed!");
//        }else {
//            Assertions.assertEquals(GlobalConstants.ERROR_MESSAGE_FOR_LOGIN,loginPage.errorMessage.getText());
//        }
//    }
//
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
//            Assertions.assertEquals(GlobalConstants.ERROR_MESSAGE_FOR_LOGIN,loginPage.errorMessage.getText());
//        }
//
//    }
//
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
//            Assertions.assertEquals(GlobalConstants.ERROR_MESSAGE_FOR_LOGIN,loginPage.errorMessage.getText());
//        }
//    }
//
//

}
