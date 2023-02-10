package itemsUtils;

import helpers.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemDetailsPage extends PageHelper {
    public ItemDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getItemTitleName() {
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

    public WebElement getSize28() {
        return size28;
    }

    public WebElement getSize29() {
        return size29;
    }

    public WebElement getSize30() {
        return size30;
    }

    public WebElement getSize32() {
        return size32;
    }

    public WebElement getSize33() {
        return size33;
    }

    public WebElement getSize34() {
        return size34;
    }

    public WebElement getSize36() {
        return size36;
    }

    public WebElement getAddItemOne() {
        return addItemOne;
    }

    public WebElement getAddItemTwo() {
        return addItemTwo;
    }

    public WebElement getAddItemThree() {
        return addItemThree;
    }

    public WebElement getAddItemFour() {
        return addItemFour;
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

    public WebElement getAddToCartDetailsButton() {
        return addToCartDetailsButton;
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

    public WebElement getItemOneNameHeader() {
        return itemOneNameHeader;
    }

    public WebElement getMessageAddedItemToCart() {
        return messageAddedItemToCart;
    }
// MESSAGE

    // HEADERS
    @FindBy(xpath = "//*[@id=\"mini-cart\"]/li/div/div/strong/a") WebElement itemOneTitleName;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div[1]/div/div") WebElement messageAddedItemToCart;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[1]/h1/span") WebElement itemOneNameHeader;
    @FindBy(xpath = "//*[@id=\"mini-cart\"]/li[2]/div/div/strong/a") WebElement itemTwoTitleName;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[3]/div[2]/div[1]") WebElement productInStock;
    @FindBy(xpath = "//*[@id=\"product-price-14\"]/span") WebElement productPrice;

    // TOPS SIZE
    @FindBy(xpath = "//*[@id=\"option-label-size-143-item-166\"]")  WebElement sizeXS;
    @FindBy(xpath = "//*[@id=\"option-label-size-143-item-167\"]") WebElement sizeS;
    @FindBy(xpath = "//*[@id=\"option-label-size-143-item-168\"]")  WebElement sizeM;
    @FindBy(xpath = "//*[@id=\"option-label-size-143-item-169\"]") WebElement sizeL;
    @FindBy(xpath = "//*[@id=\"option-label-size-143-item-170\"]") WebElement sizeXL;

    // BOTTOMS SIZE
    @FindBy(xpath = "//*[@id=\"option-label-size-143-item-171\"]") WebElement size28;
    @FindBy(xpath = "//*[@id=\"option-label-size-143-item-172\"]") WebElement size29;
    @FindBy(xpath = "//*[@id=\"option-label-size-143-item-173\"]") WebElement size30;
    @FindBy(xpath = "//*[@id=\"option-label-size-143-item-175\"]") WebElement size32;

    @FindBy(xpath = "//*[@id=\"option-label-size-143-item-176\"]") WebElement size33;
    @FindBy(xpath = "//*[@id=\"option-label-size-143-item-177\"]") WebElement size34;
    @FindBy(xpath = "//*[@id=\"option-label-size-143-item-178\"]") WebElement size36;


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
    @FindBy(xpath = "//*[@id=\"product-addtocart-button\"]") WebElement addToCartDetailsButton;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[3]/div/div[1]/form/button/span") WebElement addItemOne;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[2]/div/div/div[3]/div/div[1]/form/button/span") WebElement addItemTwo;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[2]/div/div/div[3]/div/div[1]/form/button/span") WebElement addItemThree;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[2]/div/div/div[3]/div/div[1]/form/button/span") WebElement addItemFour;
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
