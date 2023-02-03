package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class ItemsView {

    @FindBy(xpath = "//*[@id=\"toolbar-amount\"]") WebElement itemAmountMessage;
    @FindBy(xpath = "//*[@id=\"mode-grid\"]") WebElement gridView;
    @FindBy(xpath = "//*[@id=\"mode-list\"]") WebElement listView;
    @FindBy(xpath = "//*[@id=\"sorter\"]") WebElement selectSortBy;
    @FindBy(xpath = "//*[@id=\"limiter\"]") WebElement selectShowPerPage;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[4]/a") WebElement orderFilter;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/div[2]/ul/li[5]/a") WebElement paginationNext;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/div[2]/ul/li[1]/a") WebElement paginationPrev;

}
