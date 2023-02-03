package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisteredUser{
    // DROPDOWN MENU
    @FindBy(xpath = "//div[2]/header/div[1]/div/ul/li[2]/span/button") WebElement dropdownMenu;
    @FindBy(xpath = "//div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a") WebElement dropdownMyAccount;
    @FindBy(xpath = "//div[2]/header/div[1]/div/ul/li[2]/div/ul/li[2]/a") WebElement dropdownWishList;
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a") WebElement dropdownSignOut;
}
