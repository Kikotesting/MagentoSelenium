package scenarios;

import constants.CreateAccountConstants;
import constants.MessageConstants;
import pages.AccountPage;
import pages.CreateAccountPage;
import randomData.FakeData;
import reports.ListenerTest;
import base.BaseTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.GlobalPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(ListenerTest.class)
public class AccountTests extends BaseTest {
    GlobalPage globalPage;
    CreateAccountPage createAccountPage;
    AccountPage accountPage;
    FakeData fakeData;
    @Test
    @Order(1)
    @DisplayName("TC-1. Create a new account")
    void userCanCreateNewAccount() {
        globalPage = new GlobalPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        accountPage = new AccountPage(driver);
        fakeData = new FakeData();

        globalPage.clickElement(globalPage.getCreateAccountTextButton());
        String createAccountURL = "https://magento.softwaretestingboard.com/customer/account/create/";
        Assertions.assertTrue(driver.getCurrentUrl().contains(createAccountURL));
        Assertions.assertTrue(createAccountPage.getCreateAccountHeaderText().getText()
                .contains(CreateAccountConstants.CREATE_ACCOUNT_PAGE_HEADER));
        createAccountPage.setNewAccountInformation();
        Assertions.assertTrue(createAccountPage.getCreateAccountPersonalInfoText().getText()
                .contains(CreateAccountConstants.CREATE_ACCOUNT_PERSONAL_INFORMATION));
        createAccountPage.isCheckedBox();
        Assertions.assertTrue(createAccountPage.getCreateAccountSignInInfoText().getText()
                .contains(CreateAccountConstants.CREATE_ACCOUNT_SIGNIN_INFORMATION));
        createAccountPage.clickElement(createAccountPage.getCreateAccountButton());
        accountPage.waitToBeVisible(accountPage.getRegisterNewAccountMessage(),5);
        Assertions.assertEquals(accountPage.getRegisterNewAccountMessage().getText(),MessageConstants.MESSAGE_REGISTER_NEW_ACCOUNT);
    }
    @Test
    @Order(2)
    @DisplayName("TC-1. Cannot create account with empty fields in Personal information section")
    void cannotCreateAccountWithEmptyFieldsInPersonalInformationSection() {
        globalPage = new GlobalPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        accountPage = new AccountPage(driver);
        fakeData = new FakeData();

        globalPage.clickElement(globalPage.getCreateAccountTextButton());

        String createAccountURL = "https://magento.softwaretestingboard.com/customer/account/create/";
        Assertions.assertTrue(driver.getCurrentUrl().contains(createAccountURL));
        Assertions.assertTrue(createAccountPage.getCreateAccountHeaderText().getText()
                .contains(CreateAccountConstants.CREATE_ACCOUNT_PAGE_HEADER));
        Assertions.assertTrue(createAccountPage.getCreateAccountPersonalInfoText().getText()
                .contains(CreateAccountConstants.CREATE_ACCOUNT_PERSONAL_INFORMATION));

        createAccountPage.setEmptyFirstname();
        createAccountPage.setLastname();

        Assertions.assertTrue(createAccountPage.getCreateAccountSignInInfoText().getText()
                .contains(CreateAccountConstants.CREATE_ACCOUNT_SIGNIN_INFORMATION));

        createAccountPage.setEmailAddress();
        createAccountPage.setRandomPassword();
        createAccountPage.setRandomPasswordConfirmation();
        createAccountPage.clickElement(createAccountPage.getCreateAccountButton());

    }
}
