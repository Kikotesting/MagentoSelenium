package reports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakerPhoto {
    private final WebDriver driver;

    public TakerPhoto(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private static final String SCREENSHOTS_DIR = "resources/screenshots";

    // Take a photo and save to the right source
    public void takeScreenshot(){
        // Driver for screenshot
        TakesScreenshot camera = (TakesScreenshot) driver;
        // Capture a photo
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        // Create a date
        String timestamp = new SimpleDateFormat("kk-mm-ss-dd_MM_yy").format(new Date());

        // Rename the photo
        String img = "-"+ timestamp + ".png";

        // Add timestamp to the photo
        String fullImagePath = SCREENSHOTS_DIR + img;

        // Move the file from temp to the project folder
        try {
            FileUtils.copyFile(screenshot, new File(fullImagePath));
            System.out.println("Screenshot taken: " + screenshot.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
