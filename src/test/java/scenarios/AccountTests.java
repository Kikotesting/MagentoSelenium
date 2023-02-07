package scenarios;

import constants.CreateAccountConstants;
import constants.MessageConstants;
import pages.AccountPage;
import pages.CreateAccountPage;
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
    @Test
    @Order(1)
    @DisplayName("TC-1. Verify the password Strength and Requirements")
    void verifyPasswordStrengthRequirements(){
        // Object instances
        globalPage = new GlobalPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        accountPage = new AccountPage(driver);
        // Go to create account page
        globalPage.clickElement(globalPage.getCreateAccountTextButton());
        // Check URL of create account page and page-header
        Assertions.assertTrue(driver.getCurrentUrl().contains(CreateAccountConstants.CREATE_ACCOUNT_URL));
        // Scrolling
        createAccountPage.scrollToElement(createAccountPage.getCreateAccountPersonalInfoText());
        // Populate all the fields
        createAccountPage.setFirstname();
        createAccountPage.setLastname();
        createAccountPage.clickCheckedBox();
        createAccountPage.setEmailAddress();
        // Manipulating the password field
        Assertions.assertTrue(createAccountPage.getPasswordStrength().getText().contains(CreateAccountConstants.PASSWORD_NO));
        // One char
        createAccountPage.setWeakPasswordOneChar();
        createAccountPage.waitForTextUpdated(createAccountPage.getPasswordStrength(),5,CreateAccountConstants.PASSWORD_WEAK);
        Assertions.assertTrue(createAccountPage.getPasswordStrength().getText().contains(CreateAccountConstants.PASSWORD_WEAK));
        Assertions.assertTrue(createAccountPage.getPasswordRequired().getText().contains(CreateAccountConstants.MIN_LENGTH_EIGHT_SYMBOLS_REQUIRED));
        // Three characters lower
        createAccountPage.setWeakPasswordThreeCharsLower();
        createAccountPage.waitForTextUpdated(createAccountPage.getPasswordStrength(),5,CreateAccountConstants.PASSWORD_WEAK);
        Assertions.assertTrue(createAccountPage.getPasswordRequired().getText().contains(CreateAccountConstants.MIN_LENGTH_EIGHT_SYMBOLS_REQUIRED));
        // Without digit
        createAccountPage.setWeakPasswordLowerAndUpperCharsWithoutDigit();
        Assertions.assertTrue(createAccountPage.getPasswordStrength().getText().contains(CreateAccountConstants.PASSWORD_WEAK));
        Assertions.assertTrue(createAccountPage.getPasswordRequired().getText().contains(CreateAccountConstants.MIN_LENGTH_EIGHT_SYMBOLS_REQUIRED));
        // Only digits
        createAccountPage.setWeakPasswordTenDigitsWithoutChars();
        Assertions.assertTrue(createAccountPage.getPasswordStrength().getText().contains(CreateAccountConstants.PASSWORD_WEAK));
        Assertions.assertTrue(createAccountPage.getPasswordRequired().getText().contains(CreateAccountConstants.MIN_LENGTH_DIFFERENT_CLASSES_REQUIRED));
        // Chars and Digits
        createAccountPage.setMediumPasswordCharsAndTwoDigits();
        createAccountPage.pauseSeconds(1);
        Assertions.assertTrue(createAccountPage.getPasswordStrength().getText().contains(CreateAccountConstants.PASSWORD_MEDIUM));
        // Strong and very strong
        createAccountPage.setStrongPasswordLowerAndUpperCharsAndThreeDigits();
        createAccountPage.pauseSeconds(1);
        Assertions.assertTrue(createAccountPage.getPasswordStrength().getText().contains(CreateAccountConstants.PASSWORD_STRONG));
        createAccountPage.setVeryStrongPasswordLowerAndUpperCharsMoreDigitsAndSymbol();
        createAccountPage.pauseSeconds(1);
        Assertions.assertTrue(createAccountPage.getPasswordStrength().getText().contains(CreateAccountConstants.PASSWORD_VERY_STRONG));
    }
    @Test
    @Order(2)
    @DisplayName("TC-2. Cannot create account with empty Firstname or Lastname fields in Personal section")
    void cannotCreateAccountWithEmptyFieldsInPersonalInformationSection() {
        // Object instances
        globalPage = new GlobalPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        accountPage = new AccountPage(driver);

        globalPage.clickElement(globalPage.getCreateAccountTextButton());
        // Check URL of create account page and page-header
        Assertions.assertTrue(driver.getCurrentUrl().contains(CreateAccountConstants.CREATE_ACCOUNT_URL));
        Assertions.assertTrue(createAccountPage.getCreateAccountHeaderText().getText()
                .contains(CreateAccountConstants.CREATE_ACCOUNT_PAGE_HEADER));
        // Check Personal section with empty field firstname
        Assertions.assertTrue(createAccountPage.getCreateAccountPersonalInfoText().getText()
                .contains(CreateAccountConstants.CREATE_ACCOUNT_PERSONAL_INFORMATION));
        createAccountPage.scrollToElement(createAccountPage.getCreateAccountPersonalInfoText());
        createAccountPage.setEmptyFirstname();
        createAccountPage.setLastname();
        // Sign-in section is populated correctly
        Assertions.assertTrue(createAccountPage.getCreateAccountSignInInfoText().getText()
                .contains(CreateAccountConstants.CREATE_ACCOUNT_SIGNIN_INFORMATION));
        createAccountPage.scrollToElement(createAccountPage.getCreateAccountSignInInfoText());
        createAccountPage.setEmailAddress();
        createAccountPage.setRandomPassword();
        createAccountPage.setRandomPasswordConfirmation();
        createAccountPage.clickElement(createAccountPage.getCreateAccountButton());
        Assertions.assertEquals(CreateAccountConstants.ERROR_MESSAGE_REQUIRED,createAccountPage.getFirstnameRequired().getText());
        // Check Personal section with empty field for lastName
        createAccountPage.pauseSeconds(2);
        createAccountPage.scrollToElement(createAccountPage.getCreateAccountPersonalInfoText());
        createAccountPage.setFirstname();
        createAccountPage.setEmptyLastname();
        createAccountPage.scrollToElement(createAccountPage.getCreateAccountSignInInfoText());
        createAccountPage.setEmailAddress();
        createAccountPage.setRandomPassword();
        createAccountPage.setRandomPasswordConfirmation();
        createAccountPage.clickElement(createAccountPage.getCreateAccountButton());
        Assertions.assertEquals(CreateAccountConstants.ERROR_MESSAGE_REQUIRED,createAccountPage.getLastnameRequired().getText());
    }
    @Test
    @Order(3)
    @DisplayName("TC-3. Cannot create account with empty Email address or Password fields in Sign-in section")
    void cannotCreateAccountWithEmptyFieldsInSignInSection() {
        // Object instances
        globalPage = new GlobalPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        accountPage = new AccountPage(driver);

        globalPage.clickElement(globalPage.getCreateAccountTextButton());
        // Check URL of create account page and page-header
        Assertions.assertTrue(driver.getCurrentUrl().contains(CreateAccountConstants.CREATE_ACCOUNT_URL));
        // Personal section is populated correctly
        createAccountPage.scrollToElement(createAccountPage.getCreateAccountPersonalInfoText());
        createAccountPage.setFirstname();
        createAccountPage.setLastname();
        // Check Sign-in section for Empty Email
        Assertions.assertTrue(createAccountPage.getCreateAccountSignInInfoText().getText()
                .contains(CreateAccountConstants.CREATE_ACCOUNT_SIGNIN_INFORMATION));
        createAccountPage.scrollToElement(createAccountPage.getCreateAccountSignInInfoText());
        createAccountPage.setEmptyEmailAddress();
        createAccountPage.setRandomPassword();
        createAccountPage.setRandomPasswordConfirmation();
        createAccountPage.clickElement(createAccountPage.getCreateAccountButton());
        createAccountPage.scrollToElement(createAccountPage.getEmailAddressRequired());
        Assertions.assertEquals(CreateAccountConstants.ERROR_MESSAGE_REQUIRED,createAccountPage.getEmailAddressRequired().getText());
        // Check Sign-in section for Empty Password
        createAccountPage.pauseSeconds(2);
        createAccountPage.setEmailAddress();
        createAccountPage.setEmptyPassword();
        createAccountPage.setRandomPasswordConfirmation();
        createAccountPage.clickElement(createAccountPage.getCreateAccountButton());
        Assertions.assertEquals(CreateAccountConstants.ERROR_MESSAGE_REQUIRED,createAccountPage.getPasswordRequired().getText());
        Assertions.assertEquals(CreateAccountConstants.PASSWORD_NO,createAccountPage.getPasswordStrength().getText());
        Assertions.assertEquals(CreateAccountConstants.ERROR_MESSAGE_REQUIRED,createAccountPage.getPasswordConfirmationRequired().getText());
        // Check Sign-in section for Empty Confirmation Password
        createAccountPage.pauseSeconds(2);
        createAccountPage.setRandomPassword();
        createAccountPage.setEmptyConfirmationPassword();
        createAccountPage.clickElement(createAccountPage.getCreateAccountButton());
        Assertions.assertEquals(CreateAccountConstants.CONFIRMATION_PASSWORD_VALUE,createAccountPage.getPasswordConfirmationRequired().getText());
    }
    @Test
    @Order(4)
    @DisplayName("TC-4. Create a new account")
    void userCanCreateNewAccount() {
        // Object instances
        globalPage = new GlobalPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        accountPage = new AccountPage(driver);

        globalPage.clickElement(globalPage.getCreateAccountTextButton());
        // Check URL of create account page and page-header
        Assertions.assertTrue(driver.getCurrentUrl().contains(CreateAccountConstants.CREATE_ACCOUNT_URL));
        Assertions.assertTrue(createAccountPage.getCreateAccountHeaderText().getText()
                .contains(CreateAccountConstants.CREATE_ACCOUNT_PAGE_HEADER));
        // Populate all information
        createAccountPage.setNewAccountInformation();
        Assertions.assertTrue(createAccountPage.getCreateAccountPersonalInfoText().getText()
                .contains(CreateAccountConstants.CREATE_ACCOUNT_PERSONAL_INFORMATION));
        createAccountPage.clickCheckedBox();
        Assertions.assertTrue(createAccountPage.getCreateAccountSignInInfoText().getText()
                .contains(CreateAccountConstants.CREATE_ACCOUNT_SIGNIN_INFORMATION));
        createAccountPage.clickElement(createAccountPage.getCreateAccountButton());
        // Check message for creating account
        accountPage.waitToBeVisible(accountPage.getRegisterNewAccountMessage(),5);
        Assertions.assertEquals(accountPage.getRegisterNewAccountMessage().getText(),MessageConstants.MESSAGE_REGISTER_NEW_ACCOUNT);
    }

}
