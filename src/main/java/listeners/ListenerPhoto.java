package listeners;

import basePage.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class ListenerPhoto extends BasePage {
    public ListenerPhoto(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void takeScreenshot() throws IOException {
        TakesScreenshot camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        File pathScreenshot = new File(screenshot.getAbsolutePath());
        File pathProject = new File("resources/screenshots");
        FileUtils.copyFileToDirectory(pathScreenshot, pathProject);
        System.out.println("Screenshot taken: " + screenshot.getName());
    }

}
