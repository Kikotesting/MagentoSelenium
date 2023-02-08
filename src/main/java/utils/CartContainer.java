package utils;

import helpers.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartContainer extends PageHelper {

    public CartContainer(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getCartContainerButton() {
        return cartContainerButton;
    }

    public WebElement getCartCheckout() {
        return cartCheckout;
    }

    public WebElement getCartSubtotalText() {
        return cartSubtotalText;
    }

    public WebElement getCartViewAndEditText() {
        return cartViewAndEditText;
    }
    public WebElement getModalCancel() {
        return modalCancel;
    }
    public WebElement getModalConfirm() {
        return modalConfirm;
    }
    public WebElement getEmptyCartMessage() {
        return emptyCartMessage;
    }
    public WebElement getCartEdit() {
        return cartEdit;
    }
    public WebElement getCartQuantityInput() {
        return cartQuantityInput;
    }
    public WebElement getCartRemove() {
        return cartRemove;
    }
    public WebElement getCartContainerCloseButton() {
        return cartContainerCloseButton;
    }

    public WebElement getCartBadgeCounter() {
        return cartBadgeCounter;
    }

    @FindBy(xpath = "//*[@class='action showcart']") WebElement cartContainerButton;
    @FindBy(xpath = "//*[@id=\"minicart-content-wrapper\"]/div[2]/strong") WebElement emptyCartMessage;
    @FindBy(xpath = "//div[2]/header/div[2]/div[1]/a/span[2]/span[1]") WebElement cartBadgeCounter;

    @FindBy(xpath = "//*[@id=\"minicart-content-wrapper\"]/div[2]/div[2]/div/span/span") WebElement cartSubtotalText;
    @FindBy(xpath = "//*[@id=\"top-cart-btn-checkout\"]") WebElement cartCheckout;
    @FindBy(xpath = "//*[@id=\"cart-item-238207-qty\"]") WebElement cartQuantityInput;
    @FindBy(xpath = "//*[@id=\"mini-cart\"]/li/div/div/div[3]/div[1]/a") WebElement cartEdit;
    @FindBy(xpath = "//*[@id=\"mini-cart\"]/li/div/div/div[3]/div[2]/a") WebElement cartRemove;

    @FindBy(xpath = "//*[@id=\"minicart-content-wrapper\"]/div[2]/div[5]/div/a") WebElement cartViewAndEditText;
    @FindBy(xpath = "//div[4]/aside[2]/div[2]/footer/button[1]") WebElement modalCancel;
    @FindBy(xpath = "//div[4]/aside[2]/div[2]/footer/button[2]") WebElement modalConfirm;
    @FindBy(xpath = "//*[@id=\"btn-minicart-close\"]") WebElement cartContainerCloseButton;


}
