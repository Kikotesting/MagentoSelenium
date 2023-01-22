package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public WebDriver driver;
    public HomePage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }







}
