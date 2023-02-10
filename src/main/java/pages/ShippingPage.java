package pages;

import helpers.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends PageHelper {
    public ShippingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getCustomerEmailField() {
        return customerEmailField;
    }

    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public WebElement getStreetAddressField() {
        return streetAddressField;
    }

    public WebElement getCityField() {
        return cityField;
    }

    public WebElement getStateProvinceDropdownSelector() {
        return stateProvinceDropdownSelector;
    }

    public WebElement getZipCode() {
        return zipCode;
    }

    public WebElement getProvidedZipPostalCode() {
        return providedZipPostalCode;
    }

    public WebElement getPhoneNumber() {
        return phoneNumber;
    }

    public WebElement getCountryDropdownSelector() {
        return countryDropdownSelector;
    }

    public WebElement getNextButton() {
        return nextButton;
    }

    public WebElement getSideBarSummary() {
        return sideBarSummary;
    }

    @FindBy(id = "customer-email") WebElement customerEmailField;
    @FindBy(name = "firstname") WebElement firstNameField;
    @FindBy(name = "lastname") WebElement lastNameField;
    @FindBy(name = "street[0]") WebElement streetAddressField;
    @FindBy(id = "EOEEF2V") WebElement cityField;
    @FindBy(id = "IX11NWJ") WebElement stateProvinceDropdownSelector;
    @FindBy(id = "O2JV48C") WebElement zipCode;
    @FindBy(xpath = "//*[@id=\"shipping-new-address-form\"]/div[7]/div/div/span") WebElement providedZipPostalCode;
    @FindBy(id = "O6RCQEU") WebElement phoneNumber;
    @FindBy(id = "E4ULOA4") WebElement countryDropdownSelector;
    @FindBy(xpath = "//div[@id='shipping-method-buttons-container']/div/button/span") WebElement nextButton;
    @FindBy(xpath = "//*[@id=\"opc-sidebar\"]/div[1]/div/div[1]") WebElement sideBarSummary;


}

