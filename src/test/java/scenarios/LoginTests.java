package scenarios;

import constants.MessageConstants;
import pages.LoginPage;
import pages.SignOutPage;
import reports.ListenerTest;
import base.BaseTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.GlobalPage;
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
        Assertions.assertTrue(loginPage.getWelcomeDefaultMessage().getText().toLowerCase().contains("welcome msg!"));
        loginPage.setValidEmail();
        loginPage.setValidPassword();
        loginPage.clickSignInButton();
        loginPage.waitToBeVisible(loginPage.getWelcomeLoggedInMessage(), 5);
        highLightElement(driver, loginPage.getWelcomeLoggedInMessage());
        Assertions.assertTrue(loginPage.getWelcomeLoggedInMessage().getText().contains("Miso Misov!"));
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
        Assertions.assertTrue(loginPage.getWelcomeLoggedInMessage().getText().contains("Miso Misov!"));
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
        loginPage.setValidEmail();
        loginPage.setEmptyPassword();
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
        loginPage.setEmptyEmail();
        loginPage.setValidPassword();
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
        loginPage.setEmptyEmail();
        loginPage.setEmptyPassword();
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
        loginPage.setInvalidEmail();
        loginPage.clickSignInButton();
        String errorMessageRequired = "Please enter a valid email address (Ex: johndoe@domain.com).";
        Assertions.assertEquals(errorMessageRequired, loginPage.getEmailRequired().getText());
    }
    @Test
    @Order(7)
    @DisplayName("TC-7. Cannot login with valid username and wrong password")
    void userCannotLoginWithValidUsernameAndWrongPassword() {
        globalPage = new GlobalPage(driver);
        loginPage = new LoginPage(driver);
        globalPage.clickElement(globalPage.getSignInTextButton());
        loginPage.setValidEmail();
        loginPage.setWrongPassword();
        loginPage.clickSignInButton();
        String incorrectCaptcha = "Incorrect CAPTCHA";

        if (loginPage.getSignInIncorrectMessage().getText().equals(incorrectCaptcha)){
            Assertions.assertEquals(incorrectCaptcha,loginPage.getSignInIncorrectMessage().getText());
            System.out.println("Captcha is displayed!");
        }else {
            Assertions.assertEquals(MessageConstants.MESSAGE_ERROR_FOR_LOGIN,loginPage.getSignInIncorrectMessage().getText());
            System.out.println("NO Captcha");
        }
    }
    @Test
    @Order(8)
    @DisplayName("TC-8. Cannot log in with wrong username and valid password")
    void userCannotLoginWithWrongUsernameAndValidPassword(){
        globalPage = new GlobalPage(driver);
        loginPage = new LoginPage(driver);
        globalPage.clickElement(globalPage.getSignInTextButton());
        loginPage.setWrongEmail();
        loginPage.setValidPassword();
        loginPage.clickSignInButton();
        String incorrectCaptcha = "Incorrect CAPTCHA";
        if (loginPage.getSignInIncorrectMessage().getText().equals(incorrectCaptcha)){
            Assertions.assertEquals(incorrectCaptcha,loginPage.getSignInIncorrectMessage().getText());
            System.out.println("Captcha is displayed!");
        }else {
            Assertions.assertEquals(MessageConstants.MESSAGE_ERROR_FOR_LOGIN,loginPage.getSignInIncorrectMessage().getText());
            System.out.println("NO Captcha");
        }
    }
    @Test
    @Order(9)
    @DisplayName("TC-9. Cannot log in with Invalid password")
    void userCannotLoginWithInvalidUsernameAndCorrectPassword(){
        globalPage = new GlobalPage(driver);
        loginPage = new LoginPage(driver);
        globalPage.clickElement(globalPage.getSignInTextButton());
        loginPage.setValidEmail();
        loginPage.setInvalidPassword();
        loginPage.clickSignInButton();
        String incorrectCaptcha = "Incorrect CAPTCHA";
        if (loginPage.getSignInIncorrectMessage().getText().equals(incorrectCaptcha)){
            Assertions.assertEquals(incorrectCaptcha,loginPage.getSignInIncorrectMessage().getText());
            System.out.println("Captcha is displayed!");
        }else {
            Assertions.assertEquals(MessageConstants.MESSAGE_ERROR_FOR_LOGIN,loginPage.getSignInIncorrectMessage().getText());
            System.out.println("NO Captcha");
        }
    }
}
