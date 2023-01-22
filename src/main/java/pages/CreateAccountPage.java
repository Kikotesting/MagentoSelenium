package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends BasePage {

    public WebDriver driver;
    public CreateAccountPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
}
