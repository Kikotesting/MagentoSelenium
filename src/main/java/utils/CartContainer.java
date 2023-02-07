package utils;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartContainer extends Helper {

    public CartContainer(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getCartContainerButton() {
        return cartContainerButton;
    }

    public WebElement getCartContainerCheckoutButton() {
        return cartContainerCheckoutButton;
    }

    public WebElement getCartSubtotalText() {
        return cartSubtotalText;
    }

    public WebElement getViewAndEditTextButton() {
        return viewAndEditTextButton;
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

    public WebElement getCloseButton() {
        return closeButton;
    }

    public WebElement getRemoveButton() {
        return removeButton;
    }

    @FindBy(xpath = "//*[@class='action showcart']") WebElement cartContainerButton;
    @FindBy(xpath = "//*[@id=\"top-cart-btn-checkout\"]") WebElement cartContainerCheckoutButton;
    @FindBy(xpath = "//*[@id=\"minicart-content-wrapper\"]/div[2]/div[2]/div/span/span") WebElement cartSubtotalText;
    @FindBy(xpath = "//*[@id=\"minicart-content-wrapper\"]/div[2]/div[5]/div/a") WebElement viewAndEditTextButton;
    @FindBy(xpath = "//div[4]/aside[2]/div[2]/footer/button[1]") WebElement modalCancel;
    @FindBy(xpath = "//div[4]/aside[2]/div[2]/footer/button[2]") WebElement modalConfirm;
    @FindBy(xpath = "//*[@id=\"minicart-content-wrapper\"]/div[2]/strong") WebElement emptyCartMessage;
    @FindBy(xpath = "//*[@id=\"btn-minicart-close\"]") WebElement closeButton;
    @FindBy(xpath = "//*[@id=\"mini-cart\"]/li/div/div/div[3]/div[2]/a") WebElement removeButton;
}
