package pages;

import helpers.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerServicePage extends PageHelper {
    public CustomerServicePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getCustomerServiceHeaderInfo() {
        return customerServiceHeaderInfo;
    }

    public WebElement getCustomerServiceShippingInfo() {
        return customerServiceShippingInfo;
    }

    public WebElement getCustomerServiceReturnsInfo() {
        return customerServiceReturnsInfo;
    }

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/h1/span") WebElement customerServiceHeaderInfo;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/h2[1]") WebElement customerServiceShippingInfo;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/h2[2]") WebElement customerServiceReturnsInfo;






}
