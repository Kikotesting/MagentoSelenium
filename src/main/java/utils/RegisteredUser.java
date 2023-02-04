package utils;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUser extends Helper {
    public RegisteredUser(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getDropdownMenu() {
        return dropdownMenu;
    }

    public WebElement getDropdownMyAccount() {
        return dropdownMyAccount;
    }

    public WebElement getDropdownWishList() {
        return dropdownWishList;
    }

    public WebElement getDropdownSignOut() {
        return dropdownSignOut;
    }


    // DROPDOWN MENU
    @FindBy(xpath = "//div[2]/header/div[1]/div/ul/li[2]/span/button") WebElement dropdownMenu;
    @FindBy(xpath = "//div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a") WebElement dropdownMyAccount;
    @FindBy(xpath = "//div[2]/header/div[1]/div/ul/li[2]/div/ul/li[2]/a") WebElement dropdownWishList;
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a") WebElement dropdownSignOut;
}
