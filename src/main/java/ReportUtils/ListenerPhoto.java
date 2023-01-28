package ReportUtils;

import SetupPage.SetupPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class ListenerPhoto extends SetupPage {
    public ListenerPhoto(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Take a photo and save to the right source
    public void takeScreenshot() throws IOException {
        TakesScreenshot camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        File pathScreenshot = new File(screenshot.getAbsolutePath());
        File pathProject = new File("resources/screenshots");
        FileUtils.copyFileToDirectory(pathScreenshot, pathProject);
        System.out.println("Screenshot taken: " + screenshot.getName());
    }

}
