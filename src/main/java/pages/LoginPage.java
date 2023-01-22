package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends HomePage {
    public WebDriver driver;
    public LoginPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }




}
