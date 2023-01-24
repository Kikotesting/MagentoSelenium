import base.BaseTest;
import listeners.Listener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    HomePage homePage;
    AccountPage accountPage;
    LoginPage loginPage;
    @Test
    @ExtendWith(Listener.class)
    @DisplayName("TC-1. Login with valid username and password")
    void userCanLoginWithValidUsernameAndPassword(){

        homePage = new HomePage(driver);
        homePage.clickHeaderSignInButton();
        loginPage = new LoginPage(driver);
        loginPage.enterValidEmail();
        loginPage.enterValidPassword();
        loginPage.clickSignInButton();
        homePage.pauseSeconds(2);

        highLightElement(driver,homePage.welcomeUser);
        Assertions.assertEquals("Welcome, Miso Misov!",homePage.welcomeUser.getText());
        homePage.clickHeaderDropdownAccountButton();
        homePage.pauseSeconds(1);
        homePage.clickHeaderDropdownMyAccount();
        homePage.pauseSeconds(1);
        accountPage = new AccountPage(driver);
        highLightElement(driver,accountPage.myAccountTextHeader);
        homePage.pauseSeconds(1);

        Assertions.assertEquals(Constants.MY_ACCOUNT,accountPage.myAccountTextHeader.getText());
        highLightElement(driver,accountPage.accountInfoText);
        Assertions.assertEquals(Constants.ACCOUNT_INFORMATION,accountPage.accountInfoText.getText());
        highLightElement(driver,accountPage.accountContactInfoText);
        Assertions.assertEquals(Constants.ACCOUNT_CONTACT_INFORMATION,accountPage.accountContactInfoText.getText());
        highLightElement(driver,accountPage.accountNewslettersText);
        Assertions.assertEquals(Constants.ACCOUNT_NEWSLETTERS_INFORMATION,accountPage.accountNewslettersText.getText());
        highLightElement(driver,accountPage.userNameInfo);
        Assertions.assertEquals(Constants.USER_NAME_INFO,accountPage.userNameInfo.getText());
        highLightElement(driver,accountPage.addressBookInfo);
        Assertions.assertEquals(Constants.ADDRESS_BOOK,accountPage.addressBookInfo.getText());
        highLightElement(driver,accountPage.defaultBillingAddress);
        Assertions.assertEquals(Constants.ADDRESS_BOOK_DEFAULT_BILLING_ADDRESS,accountPage.defaultBillingAddress.getText());
        highLightElement(driver,accountPage.defaultBillingAddress);
        Assertions.assertEquals(Constants.ADDRESS_BOOK_DEFAULT_SHIPPING_ADDRESS,accountPage.defaultShippingAddress.getText());

    }
    @Test
    @ExtendWith(Listener.class)
    @DisplayName("TC-2. Cannot login with valid username and incorrect password")
    void userCannotLoginWithValidUsernameAndIncorrectPassword(){

        homePage = new HomePage(driver);
        homePage.clickHeaderSignInButton();
        loginPage = new LoginPage(driver);
        loginPage.enterValidEmail();
        loginPage.enterInvalidPassword();
        loginPage.clickSignInButton();
        homePage.waitToBeVisible(loginPage.errorMessage, 5);
        Assertions.assertEquals(Constants.ERROR_MESSAGE_FOR_LOGIN,loginPage.errorMessage.getText());
    }
    @Test
    @ExtendWith(Listener.class)
    @DisplayName("TC-3. Cannot login with invalid username and correct password")
    void userCannotLoginWithInvalidUsernameAndCorrectPassword(){

        homePage = new HomePage(driver);
        homePage.clickHeaderSignInButton();
        loginPage = new LoginPage(driver);
        loginPage.enterInvalidEmail();
        loginPage.enterValidPassword();
        loginPage.clickSignInButton();
        homePage.waitToBeVisible(loginPage.errorMessage, 5);
        Assertions.assertEquals(Constants.ERROR_MESSAGE_FOR_LOGIN,loginPage.errorMessage.getText());
    }
    @Test
    @ExtendWith(Listener.class)
    @DisplayName("TC-4. Cannot login with invalid username and invalid password")
    void userCannotLoginWithInvalidUsernameAndInvalidPassword(){

        homePage = new HomePage(driver);
        homePage.clickHeaderSignInButton();
        loginPage = new LoginPage(driver);
        loginPage.enterInvalidEmail();
        loginPage.enterInvalidPassword();
        loginPage.clickSignInButton();
        homePage.waitToBeVisible(loginPage.errorMessage, 5);
        Assertions.assertEquals(Constants.ERROR_MESSAGE_FOR_LOGIN,loginPage.errorMessage.getText());
    }
    @Test
    @ExtendWith(Listener.class)
    @DisplayName("TC-5. Cannot login with empty username and empty password")
    void userCannotLoginWithEmptyUsernameAndEmptyPassword(){

        homePage = new HomePage(driver);
        homePage.clickHeaderSignInButton();
        loginPage = new LoginPage(driver);
        loginPage.enterEmptyEmail();
        loginPage.enterEmptyPassword();
        loginPage.clickSignInButton();
        String errorMessageRequired = "This is a required field.";
        Assertions.assertEquals(errorMessageRequired,loginPage.emailRequired.getText());
        Assertions.assertEquals(errorMessageRequired,loginPage.passwordRequired.getText());

    }
    @Test
    @ExtendWith(Listener.class)
    @DisplayName("TC-6. Cannot login with empty username and correct password")
    void userCannotLoginWithEmptyUsernameAndCorrectPassword(){

        homePage = new HomePage(driver);
        homePage.clickHeaderSignInButton();
        loginPage = new LoginPage(driver);
        loginPage.enterEmptyEmail();
        loginPage.enterValidPassword();
        loginPage.clickSignInButton();
        String errorMessageRequired = "This is a required field.";
        Assertions.assertEquals(errorMessageRequired,loginPage.emailRequired.getText());
    }
    @Test
    @ExtendWith(Listener.class)
    @DisplayName("TC-7. Cannot login with username and empty password")
    void userCannotLoginWithUsernameAndEmptyPassword(){

        homePage = new HomePage(driver);
        homePage.clickHeaderSignInButton();
        loginPage = new LoginPage(driver);
        loginPage.enterValidEmail();
        loginPage.enterEmptyPassword();
        loginPage.clickSignInButton();
        String errorMessageRequired = "This is a required field.";
        Assertions.assertEquals(errorMessageRequired,loginPage.passwordRequired.getText());
    }


}
