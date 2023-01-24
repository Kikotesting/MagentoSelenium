import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    HomePage homePage;
    AccountPage accountPage;
    LoginPage loginPage;
    @Test
    @DisplayName("Login with valid username and password")
    void userCanLoginWithValidCredentials(){

        homePage = new HomePage(driver);
        homePage.clickHeaderSignInButton();

        loginPage = new LoginPage(driver);
        loginPage.enterValidEmail();
        loginPage.enterValidPassword();
        loginPage.clickSignInButton();
        homePage.pauseSeconds(2);
        homePage.clickHeaderDropdownAccountButton();
        homePage.pauseSeconds(2);
        homePage.clickHeaderDropdownMyAccount();
        homePage.pauseSeconds(2);
        accountPage = new AccountPage(driver);
        highLightElement(driver,accountPage.myAccountTextHeader);
        homePage.pauseSeconds(1);
        Assertions.assertEquals(Constants.MY_ACCOUNT,accountPage.myAccountTextHeader.getText());
        highLightElement(driver,accountPage.accountInfoText);
        homePage.pauseSeconds(1);
        Assertions.assertEquals(Constants.ACCOUNT_INFORMATION,accountPage.accountInfoText.getText());
        highLightElement(driver,accountPage.accountContactInfoText);
        homePage.pauseSeconds(1);
        Assertions.assertEquals(Constants.ACCOUNT_CONTACT_INFORMATION,accountPage.accountContactInfoText.getText());
        homePage.pauseSeconds(1);
        highLightElement(driver,accountPage.accountNewslettersText);
        Assertions.assertEquals(Constants.ACCOUNT_NEWSLETTERS_INFORMATION,accountPage.accountNewslettersText.getText());
    }
}
