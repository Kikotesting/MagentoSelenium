package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetails {
    public WebDriver driver;

    public ProductDetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // HEADERS
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[1]/h1") WebElement productTitleName;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[3]/div[2]/div[1]") WebElement productInStock;
    @FindBy(xpath = "//*[@id=\"product-price-1194\"]/span") WebElement productPrice;

    // SIZE
    @FindBy(xpath = "//*[@id=\"option-label-size-143-item-166\"]")  WebElement sizeXS;
    @FindBy(xpath = "//*[@id=\"option-label-size-143-item-167\"]") WebElement sizeS;
    @FindBy(xpath = "//*[@id=\"option-label-size-143-item-168\"]")  WebElement sizeM;
    @FindBy(xpath = "//*[@id=\"option-label-size-143-item-169\"]") WebElement sizeL;
    @FindBy(xpath = "//*[@id=\"option-label-size-143-item-170\"]") WebElement sizeXL;

    // COLORS
    @FindBy(xpath = "//*[@id=\"option-label-color-93-item-49\"]") WebElement colorBlack;
    @FindBy(xpath = "//*[@id=\"option-label-color-93-item-50\"]")  WebElement colorBlue;
    @FindBy(xpath = "//*[@id=\"option-label-color-93-item-51\"]") WebElement colorBrown;
    @FindBy(xpath = "///*[@id=\"option-label-color-93-item-52\"]") WebElement colorGray;
    @FindBy(xpath = "//*[@id=\"option-label-color-93-item-53\"]") WebElement colorGreen;
    @FindBy(xpath = "//*[@id=\"option-label-color-93-item-54\"]") WebElement colorLavender;
    @FindBy(xpath = "//*[@id=\"option-label-color-93-item-56\"]") WebElement colorOrange;
    @FindBy(xpath = "//*[@id=\"option-label-color-93-item-57\"]") WebElement colorPurple;
    @FindBy(xpath = "//*[@id=\"option-label-color-93-item-58\"]") WebElement colorRed;
    @FindBy(xpath = "//*[@id=\"option-label-color-93-item-59\"]") WebElement colorWhite;
    @FindBy(xpath = "//*[@id=\"option-label-color-93-item-60\"]") WebElement colorYellow;

    // FIELDS
    @FindBy(xpath = "//*[@id=\"qty\"]") WebElement quantityField;

    // BUTTONS
    @FindBy(xpath = "//*[@id=\"product-addtocart-button\"]") WebElement addToCartButton;
    @FindBy(xpath = "//*[@id=\"review-form\"]/div/div/button") WebElement submitButton;
    // TEXT BUTTON
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[5]/div/a[1]") WebElement addToWishList;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[5]/div/a[2]") WebElement addToCompare;

    // TABS
    @FindBy(xpath = "//*[@id=\"tab-label-description\"]") WebElement tabDetails;
    @FindBy(xpath = "//*[@id=\"tab-label-additional\"]") WebElement tabMoreInformation;
    @FindBy(xpath = "//*[@id=\"tab-label-reviews\"]") WebElement tabReviews;

    // TABS INFO
    @FindBy(xpath = "//*[@id=\"description\"]/div/div") WebElement detailsInfo;
    @FindBy(xpath = "//*[@id=\"additional\"]/div") WebElement moreInformationInfo;

    @FindBy(xpath = "//*[@id=\"review-form\"]/fieldset/legend/strong") WebElement reviewsProductNameText;
    @FindBy(xpath = "//*[@id=\"Rating_1_label\"]") WebElement reviewsRating1;
    @FindBy(xpath = "//*[@id=\"Rating_2_label\"]") WebElement reviewsRating2;
    @FindBy(xpath = "//*[@id=\"Rating_3_label\"]") WebElement reviewsRating3;
    @FindBy(xpath = "//*[@id=\"Rating_4_label\"]") WebElement reviewsRating4;
    @FindBy(xpath = "//*[@id=\"Rating_5_label\"]")  WebElement reviewsRating5;
    @FindBy(xpath = "//*[@id=\"nickname_field\"]") WebElement reviewsNickname;
    @FindBy(xpath = "//*[@id=\"summary_field\"]") WebElement reviewsSummary;
    @FindBy(xpath = "//*[@id=\"review_field\"]") WebElement reviewsTextArea;

}
