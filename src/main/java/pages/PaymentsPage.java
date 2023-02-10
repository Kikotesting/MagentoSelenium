package pages;

import helpers.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentsPage extends PageHelper {

    public PaymentsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getBillingAddress() {
        return billingAddress;
    }

    public WebElement getPlaceOrderButton() {
        return placeOrderButton;
    }

    public WebElement getMessageThanksForPurchase() {
        return messageThanksForPurchase;
    }

    public WebElement getOrderNumber() {
        return orderNumber;
    }

    public WebElement getContinueShoppingButton() {
        return continueShoppingButton;
    }

    public WebElement getCreateAccountButton() {
        return createAccountButton;
    }

    @FindBy(xpath = "//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[2]/div/div[2]") WebElement billingAddress;
    @FindBy(xpath = "//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button") WebElement placeOrderButton;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/h1") WebElement messageThanksForPurchase;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[1]") WebElement orderNumber;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div/div/a") WebElement continueShoppingButton;
    @FindBy(xpath = "//*[@id=\"registration\"]/div[2]/a/span") WebElement createAccountButton;



}
