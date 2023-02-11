package pages;

import helpers.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutUsPage extends PageHelper {
    public AboutUsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getAboutUsHeader() {
        return aboutUsHeader;
    }

    public WebElement getAboutUsHostedBy() {
        return aboutUsHostedBy;
    }

    public WebElement getAboutUsCourse() {
        return aboutUsCourse;
    }

    // TEXT
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/h1/span") WebElement aboutUsHeader;
    @FindBy(xpath = "//*[@class=\"column main\"]//p[1]") WebElement aboutUsHostedBy;
    @FindBy(xpath = "//*[@class=\"column main\"]//p[4]") WebElement aboutUsCourse;
}
