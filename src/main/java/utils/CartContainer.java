package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class CartContainer {
    @FindBy(className = "showcart") WebElement cartContainerButton;
    @FindBy(xpath = "//*[@id=\"top-cart-btn-checkout\"]") WebElement cartContainerCheckoutButton;
    @FindBy(xpath = "//*[@id=\"minicart-content-wrapper\"]/div[2]/div[2]/div/span/span") WebElement cartSubtotalText;
    @FindBy(xpath = "//*[@id=\"minicart-content-wrapper\"]/div[2]/div[5]/div/a") WebElement viewAndEditTextButton;
    @FindBy(xpath = "//div[4]/aside[2]/div[2]/footer/button[1]") WebElement modalCancel;
    @FindBy(xpath = "//div[4]/aside[2]/div[2]/footer/button[2]") WebElement modalConfirm;
    @FindBy(xpath = "//*[@id=\"minicart-content-wrapper\"]/div[2]/strong") WebElement emptyCartMessage;
    @FindBy(xpath = "//*[@id=\"btn-minicart-close\"]") WebElement closeButton;
}
