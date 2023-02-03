package scenarios;

import reports.ListenerTest;
import base.BaseTest;
import constants.AccountConstants;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.AccountPage;
import pages.CreateAccountPage;
import pages.HomePage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(ListenerTest.class)
public class AccountTests extends BaseTest {
    HomePage homePage;
    AccountPage accountPage;
    CreateAccountPage createAccountPage;

    @Test
    @Order(1)
    @DisplayName("TC-1. Create a new account")
    void userCanCreateNewAccount() {

        homePage = new HomePage(driver);
        homePage.createAccBtn.click();
        createAccountPage = new CreateAccountPage(driver);
        createAccountPage.registerNewUser();

        accountPage = new AccountPage(driver);
        homePage.pauseSeconds(1);
        highLightElement(driver, accountPage.registerNewAccountMessage);
        Assertions.assertEquals(AccountConstants.REGISTER_NEW_ACCOUNT_MESSAGE, accountPage.registerNewAccountMessage.getText());
        Assertions.assertEquals(AccountConstants.MY_ACCOUNT, accountPage.myAccountTextHeader.getText());
        highLightElement(driver, accountPage.accountInfoText);
        Assertions.assertEquals(AccountConstants.ACCOUNT_INFORMATION, accountPage.accountInfoText.getText());
        highLightElement(driver, accountPage.accountContactInfoText);
        Assertions.assertEquals(AccountConstants.ACCOUNT_CONTACT_INFORMATION, accountPage.accountContactInfoText.getText());
        highLightElement(driver, accountPage.accountNewslettersText);
        Assertions.assertEquals(AccountConstants.ACCOUNT_NEWSLETTERS_INFORMATION, accountPage.accountNewslettersText.getText());
        highLightElement(driver, accountPage.userNameInfo);
        highLightElement(driver, accountPage.addressBookInfo);
        Assertions.assertEquals(AccountConstants.ADDRESS_BOOK, accountPage.addressBookInfo.getText());
        highLightElement(driver, accountPage.defaultBillingAddress);
        Assertions.assertEquals(AccountConstants.ADDRESS_BOOK_DEFAULT_BILLING_ADDRESS, accountPage.defaultBillingAddress.getText());
        highLightElement(driver, accountPage.defaultBillingAddress);
        Assertions.assertEquals(AccountConstants.ADDRESS_BOOK_DEFAULT_SHIPPING_ADDRESS, accountPage.defaultShippingAddress.getText());

    }


}