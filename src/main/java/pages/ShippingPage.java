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

    public WebElement getPostcode() {
        return postcode;
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

    public WebElement getRadioButtonBestWay() {
        return radioButtonBestWay;
    }

    @FindBy(id = "customer-email") WebElement customerEmailField;
    @FindBy(name = "firstname") WebElement firstNameField;
    @FindBy(name = "lastname") WebElement lastNameField;
    @FindBy(name = "street[0]") WebElement streetAddressField;
    @FindBy(name = "city") WebElement cityField;
    @FindBy(name = "region_id") WebElement stateProvinceDropdownSelector;
    @FindBy(name = "postcode") WebElement postcode;
    @FindBy(name = "ko_unique_5") WebElement radioButtonBestWay;
    @FindBy(xpath = "//*[@id=\"shipping-new-address-form\"]/div[7]/div/div/span") WebElement providedZipPostalCode;

    @FindBy(name = "telephone") WebElement phoneNumber;
    @FindBy(name = "country_id") WebElement countryDropdownSelector;
    @FindBy(xpath = "//div[@id='shipping-method-buttons-container']/div/button/span") WebElement nextButton;
    @FindBy(xpath = "//*[@id=\"opc-sidebar\"]/div[1]/div/div[1]") WebElement sideBarSummary;


}

