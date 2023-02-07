package utils;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetails extends Helper {
    public ProductDetails(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getItemOneTitleName() {
        return itemOneTitleName;
    }
    public WebElement getItemTwoTitleName() {
        return itemTwoTitleName;
    }

    public WebElement getProductInStock() {
        return productInStock;
    }

    public WebElement getProductPrice() {
        return productPrice;
    }

    public WebElement getSizeXS() {
        return sizeXS;
    }

    public WebElement getSizeS() {
        return sizeS;
    }

    public WebElement getSizeM() {
        return sizeM;
    }

    public WebElement getSizeL() {
        return sizeL;
    }

    public WebElement getSizeXL() {
        return sizeXL;
    }

    public WebElement getColorBlack() {
        return colorBlack;
    }

    public WebElement getColorBlue() {
        return colorBlue;
    }

    public WebElement getColorBrown() {
        return colorBrown;
    }

    public WebElement getColorGray() {
        return colorGray;
    }

    public WebElement getColorGreen() {
        return colorGreen;
    }

    public WebElement getColorLavender() {
        return colorLavender;
    }

    public WebElement getColorOrange() {
        return colorOrange;
    }

    public WebElement getColorPurple() {
        return colorPurple;
    }

    public WebElement getColorRed() {
        return colorRed;
    }

    public WebElement getColorWhite() {
        return colorWhite;
    }

    public WebElement getColorYellow() {
        return colorYellow;
    }

    public WebElement getQuantityField() {
        return quantityField;
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getAddToWishList() {
        return addToWishList;
    }

    public WebElement getAddToCompare() {
        return addToCompare;
    }

    public WebElement getTabDetails() {
        return tabDetails;
    }

    public WebElement getTabMoreInformation() {
        return tabMoreInformation;
    }

    public WebElement getTabReviews() {
        return tabReviews;
    }

    public WebElement getDetailsInfo() {
        return detailsInfo;
    }

    public WebElement getMoreInformationInfo() {
        return moreInformationInfo;
    }

    public WebElement getReviewsProductNameText() {
        return reviewsProductNameText;
    }

    public WebElement getReviewsRating1() {
        return reviewsRating1;
    }

    public WebElement getReviewsRating2() {
        return reviewsRating2;
    }

    public WebElement getReviewsRating3() {
        return reviewsRating3;
    }

    public WebElement getReviewsRating4() {
        return reviewsRating4;
    }

    public WebElement getReviewsRating5() {
        return reviewsRating5;
    }

    public WebElement getReviewsNickname() {
        return reviewsNickname;
    }

    public WebElement getReviewsSummary() {
        return reviewsSummary;
    }

    public WebElement getReviewsTextArea() {
        return reviewsTextArea;
    }

    // HEADERS
    @FindBy(xpath = "//*[@id=\"mini-cart\"]/li/div/div/strong/a") WebElement itemOneTitleName;
    @FindBy(xpath = "//*[@id=\"mini-cart\"]/li[2]/div/div/strong/a") WebElement itemTwoTitleName;
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
