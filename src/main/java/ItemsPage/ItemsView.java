package ItemsPage;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemsView extends Helper {
    public ItemsView(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getItemAmountMessage() {
        return itemAmountMessage;
    }

    public WebElement getGridView() {
        return gridView;
    }

    public WebElement getListView() {
        return listView;
    }

    public WebElement getSelectSortBy() {
        return selectSortBy;
    }

    public WebElement getSelectShowPerPage() {
        return selectShowPerPage;
    }

    public WebElement getOrderFilter() {
        return orderFilter;
    }

    public WebElement getPaginationNext() {
        return paginationNext;
    }

    public WebElement getPaginationPrev() {
        return paginationPrev;
    }

    public WebElement getNoResults() {
        return noResults;
    }

    @FindBy(xpath = "//*[@id=\"toolbar-amount\"]") WebElement itemAmountMessage;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div") WebElement noResults;

    @FindBy(xpath = "//*[@id=\"mode-grid\"]") WebElement gridView;
    @FindBy(xpath = "//*[@id=\"mode-list\"]") WebElement listView;
    @FindBy(xpath = "//*[@id=\"sorter\"]") WebElement selectSortBy;
    @FindBy(xpath = "//*[@id=\"limiter\"]") WebElement selectShowPerPage;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[4]/a") WebElement orderFilter;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/div[2]/ul/li[5]/a") WebElement paginationNext;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/div[2]/ul/li[1]/a") WebElement paginationPrev;

}
